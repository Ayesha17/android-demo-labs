package com.example.softinput;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.MotionEvent;

/**
 * @author TechBirds
 * @date 14-12-29
 * @time 下午3:35
 * @vsersion 1.0
 */
public class GestureActivity extends Activity {

    private GestureDetectorCompat mDetector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_gesture);
        mDetector = new GestureDetectorCompat(this,new MyGestureListener(this,null));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public static void actionStart(Context context){
        context.startActivity(new Intent(context,GestureActivity.class));
    }

}
