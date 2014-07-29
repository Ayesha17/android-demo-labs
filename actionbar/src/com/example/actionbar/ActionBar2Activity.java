package com.example.actionbar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * @author TechBirds
 * @date 14-7-21
 * @time 下午2:29
 * @vsersion 1.0
 */
public class ActionBar2Activity extends Activity {


    private final static String TAG = "ActionBar2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.actionbar02_layout);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater menuInflater  = getMenuInflater();
        menuInflater.inflate(R.menu.action_menu,menu);

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
}
