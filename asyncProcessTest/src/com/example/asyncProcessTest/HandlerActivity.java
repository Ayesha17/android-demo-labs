package com.example.asyncProcessTest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/**
 * @author TechBirds
 * @date 14-8-8
 * @time 下午6:32
 * @vsersion 1.0
 */

public class HandlerActivity extends Activity {

    private final static String TAG = " HandlerActivity ";

    // 第一种handler
    private Handler handler1;

    // 第二种handler
    private Handler handler2;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handler1 = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);    //To change body of overridden methods use File | Settings | File Templates.

                Log.d(TAG, " handler 1 process ");

            }

        };

        new Thread(new Runnable() {
            @Override
            public void run() {

                // 耗时操作
                Log.d(TAG, " run handler 1 ");

                handler1.sendMessage(new Message());

            }
        }).start();


        // 比较标准的异步消息处理写法：
        new Thread(new Runnable() {
            @Override
            public void run() {

                // Can't create handler inside thread that has not called Looper.prepare()
                Looper.prepare();

                // 如果在子线程内创建Handler，必须Looper.prepare()，否则会奔溃。
                handler2 = new Handler() {

                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);    //To change body of overridden methods use File | Settings | File Templates.

                        Log.d(TAG, " handler 2 process ");

                    }
                };

                handler2.sendMessage(new Message());

                // 耗时操作
                Log.d(TAG, " run handler 2 ");

                Looper.loop();


            }
        }).start();

    }
}
