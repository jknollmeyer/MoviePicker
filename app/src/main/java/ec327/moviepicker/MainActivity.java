package ec327.moviepicker;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    //Declare the objects for the main acitivity
    Button FindMovieBtn, HomeBtn;
    Spinner genreSpinner, decadeSpinner;
    int presses = 0;
    Intent i;
    int maxPresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = getIntent();
        maxPresses=Integer.parseInt(i.getStringExtra("num"));
        configMovieBtn();
        configGenreSpinner();
        configDecadeSpinner();
    }
    //Configure the "find movie" button along with the text boxes
    public void configMovieBtn(){

        FindMovieBtn = (Button) findViewById(R.id.btnFindMovie);

        HomeBtn = (Button)findViewById(R.id.HomeButton);
        HomeBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent home = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(home);
            }
        });
        FindMovieBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            presses += 1;
            if(presses == maxPresses){
                System.out.println("Button Clicked");
                Intent outScreen = new Intent(getApplicationContext(), OutputActivity.class);
                outScreen.putExtra("genre", genreSpinner.getSelectedItem().toString());
                outScreen.putExtra("year", decadeSpinner.getSelectedItem().toString());
                startActivity(outScreen);

            }

            }
        });
    }
    //Configure the spinner that holds all the different possible genres
    public void configGenreSpinner(){
        String[] genres = getResources().getStringArray(R.array.genre_array);
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < genres.length; i++) {
            list.add(i, genres[i]);
        }
        genreSpinner = (Spinner)findViewById(R.id.GenreSpinner);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genreSpinner.setAdapter(dataAdapter);



    }

    public void configDecadeSpinner(){
        String[] decades = getResources().getStringArray(R.array.year_array);
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < decades.length; i++){
            list.add(i,decades[i]);
        }
        decadeSpinner = (Spinner)findViewById(R.id.DecadeSpinner);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        decadeSpinner.setAdapter(dataAdapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}