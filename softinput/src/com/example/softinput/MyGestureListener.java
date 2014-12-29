package com.example.softinput;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * @author TechBirds
 * @date 14-12-29
 * @time 下午3:56
 * @vsersion 1.0
 */
public class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
    private static final String DEBUG_TAG = "Gestures";
    private Context mContext;
    private View mView;

    public MyGestureListener(Context context,View view) {
        mContext = context;
        mView = view;
    }

    @Override
    public boolean onDown(MotionEvent event) {
        //Toast.makeText(GestureActivity.this,"onDown",Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        Toast.makeText(mContext, "onFling", Toast.LENGTH_SHORT).show();
        Util.hideSoftInput(mView, mContext);
        return true;
    }
}
