package com.example.serviceTest.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.example.serviceTest.service.AlarmRunningService;

import java.util.Date;

/**
 * @author TechBirds
 * @date 14-8-12
 * @time 下午12:31
 * @vsersion 1.0
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

//        Log.v("onReceive",new Date() + "");

        Intent i = new Intent(context, AlarmRunningService.class);
        context.startService(i);

    }

}
