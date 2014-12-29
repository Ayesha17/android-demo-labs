package com.example.softinput;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ScrollView;

/**
 * @author TechBirds
 * @date 14-12-29
 * @time 下午2:03
 * @vsersion 1.0
 */
public class Util {

    /**
     * 点击页面空白出
     *
     * @param context
     */
    public static void softInputTouchListener(final Context context) {
        ((Activity) context).getWindow().getDecorView().findViewById(android.R.id.content).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) ((Activity) context).getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                return false;
            }
        });
    }

    /**
     * 点击页面空白出
     *
     * @param context
     * @param scrollView
     */
    public static void softInputTouchListener(final Context context, final ScrollView scrollView) {
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final InputMethodManager imm1 = (InputMethodManager) ((Activity) context).getSystemService(Context.INPUT_METHOD_SERVICE);
                imm1.hideSoftInputFromWindow(scrollView.getWindowToken(), 0);
                return false;
            }
        });
    }

    /**
     * 隐藏键盘
     *
     * @param view
     * @param context
     */
    public static void hideSoftInput(View view, Context context) {
        if(view == null){
            view = ((Activity) context).getWindow().getDecorView().findViewById(android.R.id.content);
        }
        final InputMethodManager imm1 = (InputMethodManager) ((Activity) context).getSystemService(Context.INPUT_METHOD_SERVICE);
        imm1.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
