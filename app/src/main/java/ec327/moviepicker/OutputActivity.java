package ec327.moviepicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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
                Intent returnScreen =  new Intent(getApplicationContext(),MainActivity.class);
                startActivity(returnScreen);
            }
        });


        final TextView MovieOutput = (TextView)findViewById(R.id.MovieOutput);
        final TextView GenreOutput = (TextView)findViewById(R.id.GenreOutput);
        final TextView ActorOutput = (TextView)findViewById(R.id.ActorOutput);
        final TextView DirectorOutput = (TextView)findViewById(R.id.DirectorOutput);

        //Set up BufferReader using InputStream from text file at raw/testfile.txt
        InputStream ins = getResources().openRawResource(
                getResources().getIdentifier("raw/testfile","raw",getPackageName()));
        BufferedReader movieReader = new BufferedReader(new InputStreamReader(ins));
        try{
            //Current Ans 0 = genre CurrentAns 1 = movie ouput
            String[] currentAns = {"",""};
            for (int ii=0;ii<5;ii++) {
                String[] parts = movieReader.readLine().split("\\\t");
                String[] genres = parts[3].split(" ");
                System.out.println(parts[parts.length-1]);
                for(int j = 0; j < genres.length; j++) {
                    if (genres[j].equals(i.getStringExtra("genre"))) {
                        currentAns[0] = genres[j];
                        currentAns[1] = parts[1];
                    }
                }
            }
            MovieOutput.setText(currentAns[1]);
            GenreOutput.setText(currentAns[0]);
        }catch(Exception e){
            System.out.println("InputStream Exception");
        }
        /*
        get modal genre "mg"
        get movies of mg
        pick a movie
        return the title&year
         */
        //(EditText)findViewById(R.id.GenreInput)
        //getText().toString()
        //GenreOutput.setText(i.getStringExtra("genre"));

    }
}
/*
                getResources().getIdentifier("raw/testfile","raw",getPackageName()));
            String[] currentAns = {"",""};
            for (int ii=0;ii<5;ii++) {
                String[] parts = reader.readLine().split("\\\t");
//                MovieOutput.setText(parts[0]);
//                GenreOutput.setText(parts[parts.length - 1]);
                String[] arr = getResources().getStringArray(R.array.genre_array);
//                ActorOutput.setText(arr[0]);
                if (parts[parts.length-1].equals("Horror")) {
                    currentAns[0] = parts[parts.length-1];
                    currentAns[1] = parts[0];
                }
            }
            MovieOutput.setText(currentAns[1]);
            GenreOutput.setText(currentAns[0]);
 */