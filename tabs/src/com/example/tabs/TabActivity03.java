package com.example.tabs;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TabHost;
import com.example.tabs.tab3.AndroidFragment;
import com.example.tabs.tab3.AppleFragment;
import com.example.tabs.tab3.DummyTabContent;

/**
 * @author TechBirds
 * @date 14-7-25
 * @time 上午11:45
 * @vsersion 1.0
 */
public class TabActivity03 extends FragmentActivity implements  TabHost.OnTabChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tab_03_layout);


        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);
        tabHost.setup();


        /** Setting tabchangelistener for the tab */
        tabHost.setOnTabChangedListener(this);

        /** Defining tab builder for Andriod tab */
        TabHost.TabSpec tSpecAndroid = tabHost.newTabSpec("android");
        tSpecAndroid.setIndicator("Android",getResources().getDrawable(R.drawable.android));
        tSpecAndroid.setContent(new DummyTabContent(getBaseContext()));
        tabHost.addTab(tSpecAndroid);


        /** Defining tab builder for Apple tab */
        TabHost.TabSpec tSpecApple = tabHost.newTabSpec("apple");
        tSpecApple.setIndicator("Apple",getResources().getDrawable(R.drawable.apple));
        tSpecApple.setContent(new DummyTabContent(getBaseContext()));
        tabHost.addTab(tSpecApple);


    }

    @Override
    public void onTabChanged(String tabId) {

        FragmentManager fm  = getSupportFragmentManager();

        AndroidFragment androidFragment = (AndroidFragment)fm.findFragmentByTag("android");
        AppleFragment appleFragment = (AppleFragment)fm.findFragmentByTag("apple");

        FragmentTransaction ft = fm.beginTransaction();

        /** Detaches the androidfragment if exists */
        if(androidFragment!=null)
            ft.detach(androidFragment);

        /** Detaches the applefragment if exists */
        if(appleFragment!=null)
            ft.detach(appleFragment);

        /** If current tab is android */
        if(tabId.equalsIgnoreCase("android")){

            if(androidFragment==null){
                /** Create AndroidFragment and adding to fragmenttransaction */
                ft.add(R.id.realtabcontent,new AndroidFragment(), "android");
            }else{
                /** Bring to the front, if already exists in the fragmenttransaction */
                ft.attach(androidFragment);
            }

        }else{	/** If current tab is apple */
            if(appleFragment==null){
                /** Create AppleFragment and adding to fragmenttransaction */
                ft.add(R.id.realtabcontent,new AppleFragment(), "apple");
            }else{
                /** Bring to the front, if already exists in the fragmenttransaction */
                ft.attach(appleFragment);
            }
        }
        ft.commit();


    }
}
