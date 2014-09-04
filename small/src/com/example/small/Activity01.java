package com.example.small;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

/**
 * @author TechBirds
 * @date 14-8-11
 * @time 下午1:55
 * @vsersion 1.0
 */
public class Activity01 extends Activity {

    long firstClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long secondClickTime = System.currentTimeMillis();
            if (secondClickTime - firstClickTime > 3000) {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                firstClickTime = System.currentTimeMillis();
                return true;
            } else {
                finish();
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}
