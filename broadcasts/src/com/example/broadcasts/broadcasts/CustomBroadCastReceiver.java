package com.example.broadcasts.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @author TechBirds
 * @date 14-8-11
 * @time 上午11:54
 * @vsersion 1.0
 */
public class CustomBroadCastReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "自定义广播接收器", Toast.LENGTH_LONG).show();

        // 针对有序广播
        //abortBroadcast();

    }
}
