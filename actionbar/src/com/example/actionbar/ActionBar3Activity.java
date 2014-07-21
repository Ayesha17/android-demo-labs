package com.example.actionbar;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.SearchView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author TechBirds
 * @date 14-7-21
 * @time 下午2:29
 * @vsersion 1.0
 */
public class ActionBar3Activity extends Activity {


    private final static String TAG = "ActionBar3Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.actionbar03_layout);

        // 屏蔽掉物理Menu键，不然在有物理Menu键的手机上，overflow按钮会显示不出来
        setOverflowShowingAlways();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater menuInflater  = getMenuInflater();
        menuInflater.inflate(R.menu.action_menu,menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.item0)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));

        // 注意：如果重写的方法，返回值变更，那么parentActivityName(api > 16)失效
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.item1:
                Log.d(TAG,"item1");
                break;
            case R.id.item2:
                Log.d(TAG,"item2");
                break;
            case R.id.item3:
                Log.d(TAG,"item3");
                break;
            case R.id.item4:
                Log.d(TAG,"item4");
                break;

        }

        return  super.onOptionsItemSelected(item);
    }


    // 用于隐藏在overflow当中Action按钮显示出来
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod(
                            "setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

    // 屏蔽掉物理Menu键，不然在有物理Menu键的手机上，overflow按钮会显示不出来
    private void setOverflowShowingAlways() {
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class
                    .getDeclaredField("sHasPermanentMenuKey");
            menuKeyField.setAccessible(true);
            menuKeyField.setBoolean(config, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
