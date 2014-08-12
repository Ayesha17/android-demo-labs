package com.example.serviceTest.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * @author TechBirds
 * @date 14-8-8
 * @time 上午9:21
 * @vsersion 1.0
 */

public class StandardService extends Service {

    private final static String TAG = " StandardService ";

    private MyBinder myBinder;

    @Override
    public void onCreate() {
        super.onCreate();    //To change body of overridden methods use File | Settings | File Templates.

        Log.d(TAG, " onCreate ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG," onStartCommand ");
            }
        }).start();

        return super.onStartCommand(intent, flags, startId);    //To change body of overridden methods use File | Settings | File Templates.

    }

    @Override
    public void onDestroy() {
        super.onDestroy();    //To change body of overridden methods use File | Settings | File Templates.

        Log.d(TAG," onDestroy ");
    }


    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public class MyBinder extends Binder {

        public void startDownload(){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    //To change body of implemented methods use File | Settings | File Templates.
                    Log.d(TAG," start download ... ");
                }
            }).start();

        }

    }

}
