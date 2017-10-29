package com.example.mel.twoactivites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int someScore = 0;//variable to be used for the value od someScore
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        
       // Intent myIntent = new Intent( this, SecondActivity.class);

        //this code will send data to an activity
       // myIntent.putExtra( "HELLO_MESSAGE", " First activity say Hello!");

      //  startActivity( myIntent );
    }

    //Before our Activity is destroyed when the screen is rotated, Android allows you to override a method called onSaveInstanceState
    @Override
    public void onSaveInstanceState(Bundle mySavedInstanceState ) {

        super.onSaveInstanceState(mySavedInstanceState);

        mySavedInstanceState.putInt( "HIGH_SCORE", someScore );

    }
}
