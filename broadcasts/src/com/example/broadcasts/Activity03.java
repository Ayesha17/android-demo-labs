package com.example.broadcasts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author TechBirds
 * @date 14-8-11
 * @time 上午11:57
 * @vsersion 1.0
 */
public class Activity03 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent("com.example.broadcasts.CUSTOM_BROADCAST");

        // 有序广播,允许在其他程序接受该广播，同时在mainfest中指定接收器的优先级。且因为其是有序的，为此可在接收器中阻止其持续广播
        sendOrderedBroadcast(intent,null);


    }
}
