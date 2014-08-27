package com.example.datastore;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 *
 * SharedPreferences 三种方式
 *  shared preferences 默认存储在/data/data/<package>/shared_prefs下
 * @author TechBirds
 * @date 14-8-26
 * @time 上午11:40
 * @vsersion 1.0
 */
public class SharedPreferencesDataStoreUtil {

    /**
     * @param context
     * @param fileName 文件名
     * @return
     */
    public static SharedPreferences getSharedPreferences(Context context,String fileName){
        return context.getSharedPreferences(fileName,Context.MODE_PRIVATE);
    }

    /**
     * 文件名默认以当前活动的类名
     * @param context
     * @return
     */
    public static SharedPreferences getSharedPreferences(Context context){
        return( (Activity)(context)).getPreferences(Context.MODE_APPEND);
    }

    /**
     * 文件名默认以程序的包名
     * @param context
     * @return
     */
    public static SharedPreferences getDefaultSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

}
