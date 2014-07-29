package com.example.tabs;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import com.example.tabs.tab1.AndroidActivity;
import com.example.tabs.tab1.AppleActivity;
import com.example.tabs.tab1.BlackBerryActivity;
import com.example.tabs.tab1.WindowsActivity;

/**
 * @author TechBirds
 * @date 14-7-25
 * @time 上午11:45
 * @vsersion 1.0
 */
public class TabActivity02 extends TabActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tab_02_layout);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec page1 = tabHost.newTabSpec("tab1")
                .setIndicator("叫兽")
                .setContent(R.id.isanimal);

        TabHost.TabSpec page2 = tabHost.newTabSpec("tab2")
                .setIndicator("老湿")
                .setContent(R.id.alwayswet);

        TabHost.TabSpec page3 = tabHost.newTabSpec("tab3")
                .setIndicator("哪吒")
                .setContent(R.id.nezha);


        tabHost.addTab(page1);
        tabHost.addTab(page2);
        tabHost.addTab(page3);



    }
}
