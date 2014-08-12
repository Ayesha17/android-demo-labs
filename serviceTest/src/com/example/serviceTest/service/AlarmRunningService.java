package com.example.serviceTest.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import com.example.serviceTest.broadcast.AlarmReceiver;

import java.util.Date;

/**
 * @author TechBirds
 * @date 14-8-12
 * @time 下午12:25
 * @vsersion 1.0
 */
public class AlarmRunningService extends Service{

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        Log.d("onCreate",new Date() + "");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // 耗时操作
        new Thread(new Runnable() {
            @Override
            public void run() {

                Log.d("running",new Date() + "");

            }
        }).start();


        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        long triggerAtTime = SystemClock.elapsedRealtime() + 5 * 1000;
        Intent i = new Intent(this, AlarmReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this,0,i,0);

        // 方法1
        // arg1: AlarmManager.ELAPSED_REALTIME_WAKEUP 系统开机算起，并会唤醒cpu
        // arg2: triggerAtTime 触发下次执行时间
        // arg3: PendingIntent 设置接受广播的receiver
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pi);

        // 准时执行 替换set
        //alarmManager.setExact();

        // 方法2
        // 定时广播receiver
        //alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,3 * 1000,pi);

        return super.onStartCommand(intent, flags, startId);
    }
}
