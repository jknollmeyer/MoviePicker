package ec327.moviepicker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/**
 * Created by Caroline on 3/29/2015.
 */
public class Main extends ActionBarActivity implements View.OnClickListener{

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //The super keyword is used to refer to the parent class in java
        super.onCreate(savedInstanceState);

        //How the activity actually looks is inside main.xml, inside the layout folder
        setContentView(R.layout.activity_home_screen);

        Button nextButton = (Button) findViewById(R.id.next);
        nextButton.setOnClickListener(this);
    }

    @Override
	/*onClick is what is called when the buttons are pressed and they take in Views as arguments
	 * as buttons are children of the view class, buttons can polymorphically be passed in. The button
	 * that called the onClick is automatically fed in*/
    public void onClick(View v) {
        //code snippet to adapt to this project somehow?
       /* setContentView(R.layout.selected_layout);
        choco_display=(TextView)findViewById(R.id.display_choco);
        ice_display=(TextView)findViewById(R.id.display_ice);
        choco_display.setText("Chocolate: "+String.valueOf(choco.getSelectedItem()));*/
    }

    }
}
