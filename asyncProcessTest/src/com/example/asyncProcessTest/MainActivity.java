package com.example.asyncProcessTest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener{

    private final static String TAG = " MainActivity ";

    private Button  handlerThreadBtn;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        handlerThreadBtn = (Button) findViewById(R.id.handler_thread_btn);

        handlerThreadBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        //To change body of implemented methods use File | Settings | File Templates.

        switch (view.getId()){

            case R.id.handler_thread_btn :

                Intent startHandler = new Intent(this,HandlerActivity.class);
                startActivity(startHandler);

                break;

        }


    }
}
