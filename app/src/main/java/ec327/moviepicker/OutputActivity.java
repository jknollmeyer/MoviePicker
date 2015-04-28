package ec327.moviepicker;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.ArrayList;
/**
 * Created by john on 4/13/15.
 */
public class OutputActivity extends ActionBarActivity {

    Intent in;
    TextView MovieOutput, myTextView, LinkBox;
    Button ReturnButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output_activity);
        in = getIntent();
        //Initialize view objects
        ReturnButton = (Button)findViewById(R.id.button);
        MovieOutput = (TextView)findViewById(R.id.MovieOutput);
        myTextView = (TextView) findViewById(R.id.textView2);
        //Set listener for "start over" button so it returns user to the HomeScreen
        ReturnButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent returnScreen =  new Intent(getApplicationContext(),HomeScreen.class);
                startActivity(returnScreen);
            }
        });

        //Set custom font for title text
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "fonts/Lex Font.ttf");
        myTextView.setTypeface(myTypeface);
        findMovie();








    }

    public void findMovie(){
        //Set up BufferReader using InputStream from text file at raw/testfile.txt
        InputStream ins = getResources().openRawResource(
                getResources().getIdentifier("raw/testfile","raw",getPackageName()));
        BufferedReader movieReader = new BufferedReader(new InputStreamReader(ins));

        //Get the array of selections from the selection screen
        String[] decade = in.getStringArrayExtra("year");
        String[] genre = in.getStringArrayExtra("genre");
        //Get the array of every genre and decade from resources
        String[] decade_array = getResources().getStringArray(R.array.year_array);
        String[] genre_array = getResources().getStringArray(R.array.genre_array);
        //Set up arrays to measure the votes for each decade and genre
        int[] decadeCount = new int[decade_array.length];
        int[] genreCount = new int[genre_array.length];
        //The final strings for the genre and decade
        String myGenre, myDecade;
        //Variables that will store the index of the vote leader
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
        //Loop to
        for(int x =0; x < genreCount.length; x++){
            if(genreCount[maxGenre] < genreCount[x]){
                maxGenre = x;
            }
        }
        //Set final string
        myGenre = genre_array[maxGenre];
        myDecade = decade_array[maxDecade];

        ArrayList<String> goodmovies = new ArrayList<String>();

        String[] currentAns = {"",""};
        String[] parts = new String[4];
        String citationline;
        String[] genres;
        try {   // this moves the read point in testfile past the citation line and prints citation line to the console
                // avoids citation line being read as a movie line
            citationline = movieReader.readLine();
            System.out.println(citationline);
        }
        catch (Exception e) {
            System.out.println("IOstream Exception");
        }

        for(int x=0; x<1623; x++) {

            try {
                parts = movieReader.readLine().split("\\\t");
            } catch (Exception e) {
                System.out.println("IOstream Exception");
            }
            System.out.println(x);
            try {
                genres = parts[3].split(" ");
            }catch(Exception e){
                System.out.println("Parsing Error");
                continue;
            }
            String year = parts[2];
            String myyear = year.substring(1, 5);
            int yearint = Integer.parseInt(myyear);                                                               //DDD
            int want_year = Integer.parseInt(myDecade.substring(0, 4));                                                                               //DDD
            System.out.println(parts[parts.length - 1]);
            for (int y = 0; y < genres.length; y++) {

                if (genres[y].equals(myGenre)) {                                                                  //ddd
                    if (want_year < yearint && yearint < want_year + 9) {
                        currentAns[0] = genres[y];
                        currentAns[1] = parts[1];
                        goodmovies.add(currentAns[1]);
                    }

                }
            }



        }
        // chooses movie from goodmovies
        Random randomGenerator = new Random();
        int gmidx = randomGenerator.nextInt(goodmovies.size());

        MovieOutput.setText(goodmovies.get(gmidx)); //Sets MovieOutput

        //gets title of tonights movie for formatting
        String mytitle = goodmovies.get(gmidx);

        //pre-amble to every rotten tomatoes movie link needed
        String htmlpre = "http://www.rottentomatoes.com/search/?search=";

        //formats mytitle for usage in generating a viable URL
        mytitle.replace("\"","");
        mytitle.replace(".","");
        mytitle.replace("-","");
        mytitle.replace("\'","");
        mytitle = mytitle.replace(" ", "+");
        mytitle = mytitle.replace(",","");
        mytitle = mytitle.replace("&", "");
        mytitle = mytitle.replace("(","");
        mytitle = mytitle.replace(")","");
        mytitle = mytitle.replace(":","");

        StringBuilder htmlbuild = new StringBuilder();

        //concatenates htmlpre and mytitle to a full URL
        htmlbuild.append(htmlpre);
        htmlbuild.append(mytitle);

        //converts StringBuilder to String
        String html = htmlbuild.toString();
  //      MovieOutput.setText(html);            // this is an debugging thing for html
        //Creates WebView Rotten Tomatoes for result movie
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl(html);

        //If the function reaches this point, there wasn't a movie matching the criteria
        //MovieOutput.setText("We weren't able to find you a movie :(");
    }
}
/*
get [5]decade, [5]genre
sort decade by diff-avg(1950 1960 1970)->(1960 1950 1970),sort genre by modal (horror comedy comedy action) -> (comedy horror action)
go through in order, tops n^2, probably average n
 */