package com.example.broadcasts;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

/**
 * @author TechBirds
 * @date 14-8-11
 * @time 上午10:50
 * @vsersion 1.0
 */
public class Activity01 extends Activity {

    private NetWorkChangeReceiver netWorkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        netWorkChangeReceiver = new NetWorkChangeReceiver();

        // 注册接收器
        registerReceiver(netWorkChangeReceiver,intentFilter);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 动态注册的广播必须取消注册
        unregisterReceiver(netWorkChangeReceiver);
    }

    class NetWorkChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

            // 需申明网络访问权限
            ConnectivityManager  connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if(networkInfo != null && networkInfo.isAvailable()){
                Toast.makeText(context,"网络连接正常",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context,"网络断开异常",Toast.LENGTH_SHORT).show();
            }


        }
    }
}
