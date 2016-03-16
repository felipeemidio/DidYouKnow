package com.example.android.didyouknow;

import android.os.Bundle;

import com.example.android.didyouknow.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by root on 16/03/16.
 */
public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary_activity);

        Bundle extras = getIntent().getExtras();
        int value = 0;
        if (extras != null) {
            value = extras.getInt("score");
        }

        TextView tv = (TextView) findViewById(R.id.score_textview);
        tv.setText("" + value + " of 5 question" );
    }


}
