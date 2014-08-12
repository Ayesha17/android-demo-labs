package com.example.serviceTest.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * @author TechBirds
 * @date 14-8-12
 * @time 上午10:55
 * @vsersion 1.0
 */
public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }


    // 子线程工作
    @Override
    protected void onHandleIntent(Intent intent) {

        Log.d("onHandleIntent",Thread.currentThread().getId() + "");


    }

    // 自动销毁
    @Override
    public void onDestroy() {
        Log.d("onDestroy",Thread.currentThread().getId() + "");
        super.onDestroy();
    }
}
