package com.example.serviceTest.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * @author TechBirds
 * @date 14-8-8
 * @time 上午8:41
 * @vsersion 1.0
 */

public class MyService01 extends Service {

    private final static String TAG = " MyService01 ";

    @Override
    public void onCreate() {
        super.onCreate();    //To change body of overridden methods use File | Settings | File Templates.

        Log.d(TAG," onCreate ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG," onStartCommand ");
        Log.d("MyService01",Thread.currentThread() + "");

        return super.onStartCommand(intent, flags, startId);    //To change body of overridden methods use File | Settings | File Templates.

    }

    @Override
    public void onDestroy() {
        super.onDestroy();    //To change body of overridden methods use File | Settings | File Templates.

        Log.d(TAG," onDestroy ");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
