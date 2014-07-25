package com.example.tabs.tab1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author TechBirds
 * @date 14-7-25
 * @time 上午11:59
 * @vsersion 1.0
 */
public class WindowsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textview = new TextView(this);
        textview.setText("This is Windows tab");
        setContentView(textview);
    }
}
