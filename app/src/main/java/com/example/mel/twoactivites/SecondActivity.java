package com.example.mel.twoactivites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        //using the inbuilt method of Intents We'll retrieve the value for our key here
        Intent secondIntent = getIntent();

        // used to retrieve any key/value pairs you set up
        String message = secondIntent.getStringExtra("HELLO_MESSAGE");
        //the textView is the ID name of text view in second activity
        TextView myTextView = (TextView) findViewById( R.id.mainLabel);

        //this is setting that message variable we created
        // which is stored from the value of our HELLO_MESSAGE key.
        myTextView.setText( message );
    }
}
