package com.example.actionbar;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.SearchView;
import android.widget.ShareActionProvider;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author TechBirds
 * @date 14-7-21
 * @time 下午2:29
 * @vsersion 1.0
 */
public class ActionBar4Activity extends Activity {


    private final static String TAG = "ActionBar4Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater  = getMenuInflater();
        menuInflater.inflate(R.menu.action_menu_04,menu);

        MenuItem shareItem = menu.findItem(R.id.item1);

        ShareActionProvider provider = (ShareActionProvider) shareItem.getActionProvider();
        provider.setShareIntent(getDefaultIntent());

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

    // 系统所有send
    private Intent getDefaultIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        return intent;
    }

}
