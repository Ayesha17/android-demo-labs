package com.example.actionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * @author TechBirds
 * @date 14-7-21
 * @time 下午2:29
 * @vsersion 1.0
 */
public class ActionBar6Activity extends Activity {


    private final static String TAG = "ActionBar6Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("天气");
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.Tab tab = actionBar
                .newTab()
                .setText("Tab 1")
                .setTabListener(
                        new TabListener<Fragment1>(this, "tab1",
                                Fragment1.class));
        actionBar.addTab(tab);
        tab = actionBar
                .newTab()
                .setText("Tab 2")
                .setTabListener(
                        new TabListener<Fragment2>(this, "tab2",
                                Fragment2.class));
        actionBar.addTab(tab);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater  = getMenuInflater();
        menuInflater.inflate(R.menu.action_menu_06,menu);


        // 注意：如果重写的方法，返回值变更，那么parentActivityName(api > 16)失效
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.item0:
                Log.d(TAG,"item1");
                break;
            case R.id.item1:
                Log.d(TAG,"item2");
                break;
        }

        return  super.onOptionsItemSelected(item);
    }


}

class TabListener<T extends Fragment> implements ActionBar.TabListener {
    private Fragment mFragment;
    private final Activity mActivity;
    private final String mTag;
    private final Class<T> mClass;


    public TabListener(Activity activity, String tag, Class<T> clz) {
        mActivity = activity;
        mTag = tag;
        mClass = clz;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        if (mFragment == null) {
            mFragment = Fragment.instantiate(mActivity, mClass.getName());
            ft.add(android.R.id.content, mFragment, mTag);
        } else {
            ft.attach(mFragment);
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        if (mFragment != null) {
            ft.detach(mFragment);
        }
    }

    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }
}
