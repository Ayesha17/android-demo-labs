package com.example.photowallfallsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * @author TechBirds
 * @date 14-8-20
 * @time 上午7:22
 * @vsersion 1.0
 */

public class PhotoWallFallsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.act_wall);
    }
}
