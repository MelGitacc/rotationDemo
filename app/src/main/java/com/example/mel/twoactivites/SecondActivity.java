package com.example.mel.twoactivites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static String TAG = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        Log.d(TAG, "onCreate");//prints out the message when the app is running

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

    //overriding lifecycle methods
    //this log cat messages shows the state of the activity that you are running
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }
}
