package ec327.moviepicker;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class HomeScreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "PoplarStd.otf");
        TextView myTextview = (TextView) findViewById(R.id.textview1);
        myTextview.setTypeface(myTypeface);
    }

}
