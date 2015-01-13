package com.example.socket;

import android.app.Activity;
import android.widget.Toast;

/**
 * @author TechBirds
 * @date 15-1-13
 * @time 下午2:28
 * @vsersion 1.0
 */
public class Util {

    public static void showToast(final Activity activity, final String content) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(activity, content,
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

}
