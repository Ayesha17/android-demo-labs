package com.example.softinput;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void resize(View v){
        ResizeActivity.actionStart(this);
    }

    public void gesture(View v){
        GestureActivity.actionStart(this);
    }
}
