package com.example.tabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    private ListView tabsLv;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tabsLv = new ListView(this);
        tabsLv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,getItems()));

        tabsLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position){

                    case 0:

                        Intent intent1 = new Intent(MainActivity.this,TabActivity01.class);
                        startActivity(intent1);

                        break;

                    case 1:

                        Intent intent2 = new Intent(MainActivity.this,TabActivity02.class);
                        startActivity(intent2);

                        break;

                    case 2:

                        Intent intent3 = new Intent(MainActivity.this,TabActivity03.class);
                        startActivity(intent3);

                        break;



                }




            }
        });

        setContentView(tabsLv);

    }

    // 列表项
    public List<String> getItems(){

        List<String> items = new ArrayList<String>();

        items.add("TabActivity demo 1");

        items.add("TabActivity demo 2");

        items.add("TabActivity demo 3");

        return items;
    }



}
