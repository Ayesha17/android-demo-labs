package com.example.myuiapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by wang on 14-6-10.
 */
public class TestMotionEvent extends Activity{

    private static final String TAG = "TestMotionEvent";

    private TextView text1;
    private TextView text2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_motion_event);

        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int Action = event.getAction();

        float x = event.getX();
        float y = event.getY();

        Log.v(TAG,"Action = " + Action);
        Log.v(TAG,"x = " + x + "," + "y = " + y);

        text1.setText("Action = " + Action);
        text2.setText("Position = (" + x + "," + y + ")");

        return true;
    }
}
