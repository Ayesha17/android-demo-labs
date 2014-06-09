package com.example.myuiapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by wang on 14-6-9.
 */
public class TestKeyEvent extends Activity {

    private static final String TAG = "TestKeyEvent";

    private ImageView image ;
    private TextView text;
    private int alphaValue;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        Log.v(TAG,"onKeyDown:keyCode = " + keyCode);
        Log.v(TAG,"onKeyDown:String = " + event.toString());

        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_UP:
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                alphaValue += 20;
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
            case KeyEvent.KEYCODE_DPAD_LEFT:
                alphaValue -= 20;
                break;


        }

        if(alphaValue >= 0xFF){
            alphaValue = 0xFF;
        }

        if(alphaValue <= 0x0){
            alphaValue = 0x0;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_key_event);

        image = (ImageView)findViewById(R.id.image);
        text = (TextView)findViewById(R.id.text);

        alphaValue = 100;

        image.setImageAlpha(alphaValue);
        text.setText("Alpha = " + alphaValue*100/0xff + "%");

    }
}
