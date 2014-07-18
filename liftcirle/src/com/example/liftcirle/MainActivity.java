package com.example.liftcirle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

// activity 生命周期
public class MainActivity extends Activity {

    private final static String TAG = "MainActivity";

    // 触发 1.正常启动 2.back退出 | back 进入  3.home退出 | home进入

    // 1.正常启动：onCreate ->  onStart -> onResume
    // 2.back : onPause -> onStop -> onDestroy |  onCreate ->  onStart -> onResume
    // 3.home : onPause -> onStop | onRestart -> onStart -> onResume

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d(TAG,"------------onCreate-------------");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"------------onStart-------------");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"------------onRestart-------------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"------------onResume-------------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"------------onPause-------------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"------------onStop-------------");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"------------onDestroy-------------");
    }
}
