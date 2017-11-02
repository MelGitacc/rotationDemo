package com.example.mel.twoactivites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int someScore = 0;//variable to be used for the value of someScore

    private static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"onCreate");//prints out the message when the app is running

        // test for this null state
        if ( savedInstanceState != null ) {

            //To the left of an equal sign, we have our someScore variable.
            // To the right, we're calling a method on Bundle that has the name savedInstanceState.
            // This method is getInt. This is used to get an integer value from the Bundle.

            someScore = savedInstanceState.getInt( "HIGH_SCORE", 0 );

        }

    }
    // method for the second activity
    public void displaySecondActivity( View view ) {

        someScore++; //this increments the some score variable everytime the button is pressed
        TextView myTextView = (TextView) findViewById(R.id.mainLabel);

        //setting new text for the text View
        //"%s" will convert the someScore integer to string
        myTextView.setText(String.format("%s", someScore));
        
       Intent myIntent = new Intent( this, SecondActivity.class);

        //this code will send data to an activity
        myIntent.putExtra( "HELLO_MESSAGE", " First activity say Hello!");

        startActivity( myIntent );

        //lets try adding toast message when the second activity button is clicked
        //first initialise a Toast object to a toast class
        Toast toast = Toast.makeText(MainActivity.this,"You will be directed to second activity",Toast.LENGTH_LONG );
        toast.setGravity(Gravity.CENTER, 0,0);//This will set the positioning of your toast message
        toast.show();//this will show the toast message on the screen
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

    //Before our Activity is destroyed when the screen is rotated, Android allows you to override a method called onSaveInstanceState
    @Override
    public void onSaveInstanceState(Bundle mySavedInstanceState ) {

        super.onSaveInstanceState(mySavedInstanceState);

        mySavedInstanceState.putInt( "HIGH_SCORE", someScore );

    }
}
