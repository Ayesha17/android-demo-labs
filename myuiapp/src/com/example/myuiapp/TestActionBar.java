package com.example.myuiapp;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.ActionBar;
import android.app.Activity;


public class TestActionBar extends Activity {
    private ActionBar mActionBar;
    private Button mShowActionBarButton;
    private Button mHideActionBarButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_action_bar);
        init();
    }


    private void init(){
        //得到Activity的ActionBar
        mActionBar=getActionBar();
        mShowActionBarButton=(Button) findViewById(R.id.showActionBarButton);
        mShowActionBarButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //显示ActionBar
                mActionBar.show();
            }
        });
        mHideActionBarButton=(Button) findViewById(R.id.hideActionBarButton);
        mHideActionBarButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //隐藏ActionBar
                mActionBar.hide();
            }
        });
    }
}

