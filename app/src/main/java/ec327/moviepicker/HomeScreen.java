package ec327.moviepicker;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Caroline on 4/17/2015.
 */



public class HomeScreen extends ActionBarActivity {

    Button startBtn;
    Spinner numSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        startBtn = (Button) findViewById(R.id.StartButton);
        numSpinner = (Spinner) findViewById(R.id.PeopleSpinner);
        startBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent toHome = new Intent(getApplicationContext(), MainActivity.class);
                toHome.putExtra("num", numSpinner.getSelectedItem().toString());
                startActivity(toHome);
            }


        });
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "fonts/Lex Font.ttf");
        TextView myTextview = (TextView) findViewById(R.id.textview1);
        myTextview.setTypeface(myTypeface);
    }

    //@Override
/*    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }*/

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