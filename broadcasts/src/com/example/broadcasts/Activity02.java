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
public class Activity02 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent("com.example.broadcasts.CUSTOM_BROADCAST");
        sendBroadcast(intent);

    }
}
