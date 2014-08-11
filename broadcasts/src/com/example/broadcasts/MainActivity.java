package com.example.broadcasts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{


    private Button receive_network_system_broadcast;
    private Button receive_boot_system_broadcast;
    private Button receive_custom_broadcast;
    private Button receive_custom_order_broadcast;
    private Button receive_local_custom_broadcast;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        receive_network_system_broadcast = (Button)findViewById(R.id.receive_network_system_broadcast);
        receive_boot_system_broadcast = (Button)findViewById(R.id.receive_boot_system_broadcast);
        receive_custom_broadcast = (Button)findViewById(R.id.receive_custom_broadcast);
        receive_custom_order_broadcast = (Button)findViewById(R.id.receive_custom_order_broadcast);
        receive_local_custom_broadcast = (Button)findViewById(R.id.receive_local_custom_broadcast);

        receive_network_system_broadcast.setOnClickListener(this);
        receive_boot_system_broadcast.setOnClickListener(this);
        receive_custom_broadcast.setOnClickListener(this);
        receive_custom_order_broadcast.setOnClickListener(this);
        receive_local_custom_broadcast.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.receive_network_system_broadcast:

                Intent intent01 = new Intent(this,Activity01.class);
                startActivity(intent01);

                break;
            case R.id.receive_boot_system_broadcast:

                Toast.makeText(this,"未绑定事件",Toast.LENGTH_SHORT).show();
                break;
            case R.id.receive_custom_broadcast:

                Intent intent02 = new Intent(this,Activity02.class);
                startActivity(intent02);

                break;
            case R.id.receive_custom_order_broadcast:

                Intent intent03 = new Intent(this,Activity03.class);
                startActivity(intent03);

                break;
            case R.id.receive_local_custom_broadcast:

                Intent intent04 = new Intent(this,Activity04.class);
                startActivity(intent04);

                break;

        }

    }
}
