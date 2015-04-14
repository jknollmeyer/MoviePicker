package ec327.moviepicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by john on 4/13/15.
 */
public class OutputActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output_activity);
        Intent i = getIntent();
        final TextView GenreOutput = (TextView)findViewById(R.id.GenreOutput);
        final TextView ActorOutput = (TextView)findViewById(R.id.ActorOutput);
        final TextView DirectorOutput = (TextView)findViewById(R.id.DirectorOutput);

        GenreOutput.setText(i.getStringExtra("genre"));

    }
}
