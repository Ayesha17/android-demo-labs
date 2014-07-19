package com.example.viewpager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

/**
 * @author TechBirds
 * @date 14-7-19
 * @time 下午4:24
 * @vsersion 1.0
 */

public class MainActivity extends Activity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private final String first_start = "first_start";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.main);

        // 第一次程序安装才启动->引导页
        sharedPreferences = getSharedPreferences("com.example.viewpager", Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean(first_start,true)){

            editor = sharedPreferences.edit();
            editor.putBoolean(first_start,false);
            editor.commit();

            Intent intent = new Intent(this,GuideActivity.class);
            startActivity(intent);
            finish();

        }
    }
}
