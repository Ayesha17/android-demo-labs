package com.example.softinput;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * 根容器：
 * 1. LinearLayout由于布局的限制(线性)，会存在顶部上去的可能。
 * 2. RelativeLayout 由于是相对布局，如果将其设置未相对与根布局的属性。(android:layout_alignParentBottom="true")
 *    那是可以将其顶上去的。但是由于相对布局的原因，此时有可能对其他控件进行覆盖。
 * @author TechBirds
 * @date 14-12-29
 * @time 上午10:17
 * @vsersion 1.0
 */
public class ResizeActivity extends Activity {

    private final String DEBUG_TAG = "ResizeActivity";

    private ScrollView mScrollView;
    private GestureDetectorCompat mDetector;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_resize);
        mScrollView = (ScrollView) findViewById(R.id.scroll_view);

        mDetector = new GestureDetectorCompat(this,new MyGestureListener(this,mScrollView));
        mScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mDetector.onTouchEvent(event);
                return false;
            }
        });
    }

    public static void actionStart(Context context){
        context.startActivity(new Intent(context,ResizeActivity.class));
    }


}
