package com.example.expandablelistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


    }


    public void bt1Click(View view){

        Intent intent = new Intent(MainActivity.this,SimpleExpandableListViewActivity.class);
        startActivity(intent);

    }

    public void bt2Click(View view){

        Intent intent = new Intent(MainActivity.this,CustomExpandableListViewActivity.class);
        startActivity(intent);

    }


}
