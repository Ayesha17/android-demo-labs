package com.example.actionbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button button1 = (Button)findViewById(R.id.actionbar_bt);
        Button button2 = (Button)findViewById(R.id.actionbar02_bt);
        Button button3 = (Button)findViewById(R.id.actionbar03_bt);
        Button button4 = (Button)findViewById(R.id.actionbar04_bt);
        Button button5 = (Button)findViewById(R.id.actionbar05_bt);
        Button button6 = (Button)findViewById(R.id.actionbar06_bt);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id){

            case R.id.actionbar_bt:

                Intent intent = new Intent(this,ActionBar1Activity.class);
                startActivity(intent);

                break;
            case R.id.actionbar02_bt:

                Intent intent02 = new Intent(this,ActionBar2Activity.class);
                startActivity(intent02);

                break;
            case R.id.actionbar03_bt:

                Intent intent03 = new Intent(this,ActionBar3Activity.class);
                startActivity(intent03);

                break;
            case R.id.actionbar04_bt:

                Intent intent04 = new Intent(this,ActionBar4Activity.class);
                startActivity(intent04);

                break;
            case R.id.actionbar05_bt:

                Intent intent05 = new Intent(this,ActionBar5Activity.class);
                startActivity(intent05);

                break;
            case R.id.actionbar06_bt:

                Intent intent06 = new Intent(this,ActionBar6Activity.class);
                startActivity(intent06);

                break;

        }


    }
}
