package com.example.small;

import android.app.Application;
import android.content.Context;

/**
 * @author TechBirds
 * @date 14-8-12
 * @time 下午5:49
 * @vsersion 1.0
 */
public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    // 获取全局Context
    public static Context getContext(){
        return  context;
    }
}
