package com.example.tabs.tab3;

import android.content.Context;
import android.view.View;
import android.widget.TabHost;

/**
 * @author TechBirds
 * @date 14-7-28
 * @time 上午10:22
 * @vsersion 1.0
 */
public class DummyTabContent implements TabHost.TabContentFactory {
    private Context mContext;

    public DummyTabContent(Context context){
        mContext = context;
    }


    @Override
    public View createTabContent(String tag) {
        View v = new View(mContext);
        return v;
    }


}
