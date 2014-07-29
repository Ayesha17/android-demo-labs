package com.example.actionbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * @author TechBirds
 * @date 14-7-21
 * @time 下午2:29
 * @vsersion 1.0
 */
public class ActionBar1Activity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.actionbar01_layout);


        Button showBt = (Button) findViewById(R.id.show_bt);
        showBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 如果默认配置 android:theme="@android:style/Theme.Holo.NoActionBar" (隐藏actionbar)。
                // 因此getActionBar()为null,会报错
                getActionBar().show();
            }
        });


        Button hideBt = (Button) findViewById(R.id.hide_bt);
        hideBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActionBar().hide();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuItem addItem = menu.add(0, 1, 0, "save");
        MenuItem deleteItem = menu.add(0, 2, 1, "delete");

        addItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        deleteItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        return true;
    }
}
