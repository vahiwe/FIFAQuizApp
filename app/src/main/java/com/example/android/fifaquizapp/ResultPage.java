package com.example.android.fifaquizapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);


        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Champ.ttf");
        TextView text = (TextView)findViewById(R.id.result);
        text.setText(message);
        text.setTypeface(typeface);
    }

}
