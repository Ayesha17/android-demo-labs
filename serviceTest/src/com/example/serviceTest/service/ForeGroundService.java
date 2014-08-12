package com.example.serviceTest.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.example.serviceTest.MyActivity;
import com.example.serviceTest.R;

/**
 * @author TechBirds
 * @date 14-8-8
 * @time 上午9:34
 * @vsersion 1.0
 */

public class ForeGroundService extends Service {

    private final static String TAG = " ForeGroundService ";
    private MyBinder myBinder = new MyBinder();


    @Override
    public void onCreate() {
        super.onCreate();    //To change body of overridden methods use File | Settings | File Templates.

        Notification notification = new Notification(R.drawable.ic_launcher,"有通知到来",System.currentTimeMillis());
        Intent intent = new Intent(this, MyActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        notification.setLatestEventInfo(this,"这是通知的标题","这是通知的内容",pendingIntent);

        // 后台service - > 前台service
        startForeground(1,notification);


        Log.d(TAG, " onCreate ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG," onStartCommand ");

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

            Log.d(TAG," start download ... ");

        }

    }
}
