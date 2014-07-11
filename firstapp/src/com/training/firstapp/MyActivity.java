package com.training.firstapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MyActivity extends Activity {

    public final static String EXTRA_MESSAGE = "com.training.firstapp.message";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

//        ActionBar actionBar = getActionBar();
//        actionBar.hide();

    }

    // sendMessage
    public void sendMessage(View view){

        TextView vEditMessage = (TextView)findViewById(R.id.edit_message);

        String message = vEditMessage.getText().toString();

        Intent intent = new Intent(this,DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE,message);



        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
                //openSearch();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
