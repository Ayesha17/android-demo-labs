package com.example.broadcasts.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * @author TechBirds
 * @date 14-8-11
 * @time 上午11:10
 * @vsersion 1.0
 */
public class BootCompleteReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // 特殊机型，如小米3(V5)，需要手动添加启动项，才可接受该广播
        Log.d("BootCompleteReceiver","开机启动");
        Toast.makeText(context,"开机启动",Toast.LENGTH_LONG);
    }
}
