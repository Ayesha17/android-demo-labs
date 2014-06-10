package com.example.myuiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by wang on 14-6-10.
 */
public class TestForwardTarget extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forward_target);

        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK,(new Intent()).setAction("Value1"));
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK,(new Intent()).setAction("Value2"));
                finish();
            }
        });



    }
}
