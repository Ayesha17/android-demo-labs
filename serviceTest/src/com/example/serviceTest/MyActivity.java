package com.example.serviceTest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import com.example.serviceTest.service.ForeGroundService;
import com.example.serviceTest.service.MyService01;
import com.example.serviceTest.service.MyService02;
import com.example.serviceTest.service.StandardService;

public class MyActivity extends Activity implements View.OnClickListener{

    private Button serviceStartBtn;
    private Button serviceStopBtn;
    private Button serviceBindBtn;
    private Button serviceUnBindBtn;
    private Button serviceStandardBindBtn;
    private Button serviceStandardUnBindBtn;
    private Button serviceForeGroundStartBtn;
    private Button serviceForeGroundStopBtn;

    private  MyService02.MyBinder myBinder01;
    private StandardService.MyBinder myBinder02;


    private ServiceConnection connection1 = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //To change body of implemented methods use File | Settings | File Templates.

            myBinder01 = (MyService02.MyBinder) iBinder;
            myBinder01.startDownload();

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    };


    private ServiceConnection connection2 = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //To change body of implemented methods use File | Settings | File Templates.

            myBinder02 = (StandardService.MyBinder) iBinder;
            myBinder02.startDownload();

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    };


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initView();

    }


    private void initView(){

        serviceStartBtn = (Button) findViewById(R.id.service_start_btn);
        serviceStopBtn = (Button) findViewById(R.id.service_stop_btn);
        serviceBindBtn = (Button) findViewById(R.id.service_bind_btn);
        serviceUnBindBtn = (Button) findViewById(R.id.service_unbind_btn);
        serviceStandardBindBtn = (Button) findViewById(R.id.service_standard_bind_btn);
        serviceStandardUnBindBtn = (Button) findViewById(R.id.service_standard_unbind_btn);
        serviceForeGroundStartBtn = (Button) findViewById(R.id.service_fore_ground_start_btn);
        serviceForeGroundStopBtn = (Button) findViewById(R.id.service_fore_ground_stop_btn);

        serviceStartBtn.setOnClickListener(this);
        serviceStopBtn.setOnClickListener(this);
        serviceBindBtn.setOnClickListener(this);
        serviceUnBindBtn.setOnClickListener(this);
        serviceStandardBindBtn.setOnClickListener(this);
        serviceStandardUnBindBtn.setOnClickListener(this);
        serviceForeGroundStartBtn.setOnClickListener(this);
        serviceForeGroundStopBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.service_start_btn :
                Intent startIntent = new Intent(this, MyService01.class);
                startService(startIntent);
                break;
            case R.id.service_stop_btn :
                Intent stopIntent = new Intent(this, MyService01.class);
                stopService(stopIntent);
                break;
            case R.id.service_bind_btn :
                Intent bindIntent = new Intent(this,MyService02.class);
                bindService(bindIntent,connection1,BIND_AUTO_CREATE);
                break;
            case R.id.service_unbind_btn :
                unbindService(connection1);
                break;
            case R.id.service_standard_bind_btn :
                Intent standardBindIntent = new Intent(this,StandardService.class);
                bindService(standardBindIntent,connection2,BIND_AUTO_CREATE);
                break;
            case R.id.service_standard_unbind_btn :
                unbindService(connection2);
            case R.id.service_fore_ground_start_btn :
                Intent foreGroundStartIntent = new Intent(this, ForeGroundService.class);
                startService(foreGroundStartIntent);
                break;
            case R.id.service_fore_ground_stop_btn :
                Intent foreGroundStopIntent = new Intent(this, ForeGroundService.class);
                stopService(foreGroundStopIntent);
            default:
                break;

        }

    }
}
