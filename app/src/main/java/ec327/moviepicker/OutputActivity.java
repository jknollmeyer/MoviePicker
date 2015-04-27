package ec327.moviepicker;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.ArrayList;
/**
 * Created by john on 4/13/15.
 */
public class OutputActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output_activity);
        Intent i = getIntent();
        Button ReturnButton = (Button)findViewById(R.id.ReturnButton);
        ReturnButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent returnScreen =  new Intent(getApplicationContext(),HomeScreen.class);
                startActivity(returnScreen);
            }
        });
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "fonts/Lex Font.ttf");
        TextView myTextview = (TextView) findViewById(R.id.textView2);
        myTextview.setTypeface(myTypeface);


        final TextView MovieOutput = (TextView)findViewById(R.id.MovieOutput);


        //Set up BufferReader using InputStream from text file at raw/testfile.txt
        InputStream ins = getResources().openRawResource(
                getResources().getIdentifier("raw/testfile","raw",getPackageName()));
        BufferedReader movieReader = new BufferedReader(new InputStreamReader(ins));

        String[] decade = i.getStringArrayExtra("year");//.substring(0,4);
        String[] genre = i.getStringArrayExtra("genre");
        String[] decade_array = getResources().getStringArray(R.array.year_array);
        String[] genre_array = getResources().getStringArray(R.array.genre_array);
        int[] decadeCount = new int[decade_array.length];
        int[] genreCount = new int[genre_array.length];
        String myGenre, myDecade;
        int maxGenre =0, maxDecade=0;
        //Loop to zero-initialize the count arrays
        for(int x = 0; x < decadeCount.length; x++){
            decadeCount[x] = genreCount[x] = 0;
        }
        //Loop to get the counts for the decades
        for(int x = 0; x < decade.length; x++) {
            for (int y = 0; y < decade_array.length; y++) {
                if (decade[x].equals(decade_array[y])) {
                    decadeCount[y] += 1;
                    break;
                }
            }
        }
        //Loop to get the counts for the genres
        for(int x = 0; x < genre.length; x++) {
            for (int y = 0; y < genre_array.length; y++) {
                if (genre[x].equals(genre_array[y])) {
                    genreCount[y] += 1;
                    break;
                }
            }
        }
        //Loop to get decade with the most votes
        for(int x = 0; x < decadeCount.length; x++){
            if(decadeCount[maxDecade] < decadeCount[x]){
                maxDecade = x;
            }
        }
        for(int x =0; x < genreCount.length; x++){
            if(genreCount[maxGenre] < genreCount[x]){
                maxGenre = x;
            }
        }
        myGenre = genre_array[maxGenre];
        myDecade = decade_array[maxDecade];
        ArrayList<String> goodmovies = new ArrayList<>();
        try{

            String[] currentAns = {"",""};
            for(int x=0; x<783; x++) {
                String[] parts = movieReader.readLine().split("\\\t");
                String[] genres = parts[3].split(" ");
                String year = parts[2];
                String myyear = year.substring(1,5);
                int yearint = Integer.parseInt(myyear);                                                               //DDD
                int want_year = Integer.parseInt(myDecade.substring(0,4));                                                                               //DDD
                System.out.println(parts[parts.length-1]);
                for(int y = 0; y < genres.length; y++) {

                    if (genres[y].equals(myGenre)) {                                                                  //ddd
                        if (want_year < yearint && yearint < want_year+ 9) {
                            currentAns[0] = genres[y];
                            currentAns[1] = parts[1];
                            goodmovies.add(currentAns[1]);
                            return;
                        }
                    }
                }
                Random randomGenerator = new Random();
                int gmidx = randomGenerator.nextInt(goodmovies.size());
                MovieOutput.setText(goodmovies.get(gmidx));


            }

        }catch(Exception inputStreamException){
            System.out.println("InputStream Exception");
        }
    }
}
/*
get [5]decade, [5]genre
sort decade by diff-avg(1950 1960 1970)->(1960 1950 1970),sort genre by modal (horror comedy comedy action) -> (comedy horror action)
go through in order, tops n^2, probably average n
 */