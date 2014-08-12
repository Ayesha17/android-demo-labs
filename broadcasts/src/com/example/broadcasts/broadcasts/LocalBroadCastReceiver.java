package com.example.broadcasts.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @author TechBirds
 * @date 14-8-11
 * @time 下午1:16
 * @vsersion 1.0
 */
public class LocalBroadCastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // 静态注册貌似无法
        Toast.makeText(context, "自定义本地广播接收器", Toast.LENGTH_LONG).show();

    }

}
