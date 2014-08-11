package com.example.broadcasts;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.broadcasts.broadcasts.LocalBroadCastReceiver;

/**
 * @author TechBirds
 * @date 14-8-11
 * @time 下午12:57
 * @vsersion 1.0
 */
public class Activity04 extends Activity {

    private LocalBroadcastManager localBroadcastManager;
    private LocalBroadCastReceiver localBroadCastReceiver;

    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        // 注册
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcasts.LOCAL_CUSTOM_BROADCAST");
        localBroadCastReceiver = new LocalBroadCastReceiver();
        localBroadcastManager.registerReceiver(localBroadCastReceiver,intentFilter);


        // 发送
        Intent intent = new Intent("com.example.broadcasts.LOCAL_CUSTOM_BROADCAST");
        localBroadcastManager.sendBroadcast(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localBroadCastReceiver);
    }
}
