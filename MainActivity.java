package com.example.will.ec327app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button FindMovieBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FindMovieBtn = (Button) findViewById(R.id.btnFindMovie);

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

        <item>Adult</item>
        <item>Action</item>
        <item>Romance</item>
        <item>Thriller</item>
        <item>Animation</item>
        <item>Family</item>
        <item>Horror</item>
        <item>Crime</item>
        <item>Music</item>
        <item>Adventure</item>
        <item>Fantasy</item>
        <item>Sci-Fi</item>
        <item>Mystery</item>
        <item>Biography</item>
        <item>History</item>
        <item>Sport</item>
        <item>Musical</item>
        <item>War</item>
        <item>Western</item>
    </string-array>

</resources>
