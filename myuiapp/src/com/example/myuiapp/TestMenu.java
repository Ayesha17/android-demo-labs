package com.example.myuiapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

/**
 * Created by wang on 14-6-10.
 */
public class TestMenu extends Activity {

    private Button button;

    public TestMenu(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_menu);
        button = (Button) findViewById(R.id.button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);


        menu.add(0, Menu.FIRST, 1, "red");
        menu.add(0, Menu.FIRST + 1, 2, "green");
        menu.add(0, Menu.FIRST + 2, 3, "blue");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case Menu.FIRST :
                button.setBackgroundColor(Color.RED);
                return true;
            case Menu.FIRST + 1:
                button.setBackgroundColor(Color.GREEN);
                return true;
            case Menu.FIRST + 2:
                button.setBackgroundColor(Color.BLUE);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu (Menu menu) {

        return true;
    }
}
