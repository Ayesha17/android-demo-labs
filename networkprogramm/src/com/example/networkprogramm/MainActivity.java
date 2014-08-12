package com.example.networkprogramm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button http01;
    private Button http02;
    private Button http03;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        http01 = (Button) findViewById(R.id.network_http_request_1_btn);
        http02 = (Button) findViewById(R.id.network_http_request_2_btn);
        http03 = (Button) findViewById(R.id.network_http_request_3_btn);

        http01.setOnClickListener(this);
        http02.setOnClickListener(this);
        http03.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.network_http_request_1_btn:

                Intent intent1 = new Intent(this,Http01Activity.class);
                startActivity(intent1);

                break;
            case R.id.network_http_request_2_btn:

                Intent intent2 = new Intent(this,Http02Activity.class);
                startActivity(intent2);

                break;
            case R.id.network_http_request_3_btn:

                Intent intent3 = new Intent(this,Http03Activity.class);
                startActivity(intent3);

                break;
            default:
                break;

        }

    }
}
