package ec327.moviepicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
        try{
            MovieOutput.setText(reader.readLine());
        }catch(Exception e){
            System.out.println("InputStream Exception");
        }


        GenreOutput.setText(i.getStringExtra("genre"));

    }
}
