package com.example.socket.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.Vibrator;
import android.util.Log;
import com.example.socket.MainApplication;
import com.example.socket.im.client.Client;
import com.example.socket.im.client.ClientFactory;
import com.example.socket.im.client.IClientEvent;
import com.example.socket.im.client.Ticket;
import com.example.socket.im.client.test.TestLogger;
import com.example.socket.im.vo.Message;

/**
 * @author TechBirds
 * @date 15-1-13
 * @time 上午9:44
 * @vsersion 1.0
 */
public class IMService extends Service implements IClientEvent{

    private final String TAG = "IMService";

    String IM_TEST_SERVER = "192.168.1.200:5222";
    String mPhoneNumber = "18222222222";
    String mToken = "fc5b40b61e4268bae15f523dcd6ffa5d";
    Client mClient;

    public enum IMServiceAction {
        Start("co.yun56.apps.assistant.service.START"),
        Restart("co.yun56.apps.assistant.service.RESTART"),
        NetworkChangetd("co.yun56.apps.assistant.service.NETWORKCHANGE"),
        Ping("co.yun56.apps.assistant.service.PING"),
        PingCheck("co.yun56.apps.assistant.service.PINGCHECK"),
        Stop("co.yun56.apps.assistant.service.STOP"),
        Other("co.yun56.apps.assistant.service.OTHER");
        String name;
        IMServiceAction(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public static IMServiceAction getAction(String name) {
            return null;
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        login();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != mClient) {
            mClient.logout();
        }
    }

    private void login() {
        ClientFactory factory = ClientFactory.getInstance(IM_TEST_SERVER, new TestLogger());
        mClient = factory.getClient(mPhoneNumber, "", mToken, this);
        if (null != mClient) {
            mClient.setOs(Build.MODEL);
            mClient.setVer(MainApplication.getCurrentVersion());
            mClient.setOsVer(Build.VERSION.RELEASE);
            mClient.login();
        }
    }

    public static void actionStart(Context context, IMServiceAction action) {
        Intent intent = new Intent(context, IMService.class);
        if (null != action) {
            intent.setAction(action.getName());
        } else {
            intent.setAction(IMServiceAction.Other.getName());
        }
        context.startService(intent);
    }

    public static Intent actionStart(Context context) {
        Intent intent = new Intent(context, IMService.class);
        context.startService(intent);
        return intent;
    }

    public static Intent actionStop(Context context) {
        Intent intent = new Intent(context, IMService.class);
        context.stopService(intent);
        return intent;
    }

    @Override
    public void onLogin(Client client) {
        Log.d(TAG,"onLogin");
    }

    @Override
    public void onLoginAccessDenied(Client client) {
        Log.d(TAG,"onLoginAccessDenied");
    }

    @Override
    public void onLoginFail(Client client) {
        Log.d(TAG,"onLoginFail");
    }

    @Override
    public void onLoginSuccess(Client client) {
        Log.d(TAG,"onLoginSuccess");
    }

    @Override
    public void onConnect(Client client) {
        Log.d(TAG,"onConnect");
    }

    @Override
    public void onConnectFail(Client client) {
        Log.d(TAG,"onConnectFail");
    }

    @Override
    public void onConnectSuccess(Client client) {
        Log.d(TAG,"onConnectSuccess");
    }

    @Override
    public void onLogout(Client client) {
        Log.d(TAG,"onLogout");
    }

    @Override
    public void onLogoutSuccess(Client client) {
        Log.d(TAG,"onLogoutSuccess");
    }

    @Override
    public void onSend(Client client, Message message) {
        Log.d(TAG,"onSend");
    }

    @Override
    public void onSendFail(Client client, Message message) {
        Log.d(TAG,"onSendFail");
    }

    @Override
    public void onSendSuccess(Client client, Message message) {
        Log.d(TAG,"onSendSuccess");
    }

    @Override
    public void onReceiveMessage(Client client, Message message) {
        Log.d(TAG,"onReceiveMessage");
    }

    @Override
    public void onReceiveMessageSuccess(Client client, Message message) {
        Log.d(TAG,"onReceiveMessageSuccess");
    }

    @Override
    public void onSyncSendMessage(Client client, Message message) {
        Log.d(TAG,"onSyncSendMessage");
    }

    @Override
    public void onForceLogOut(Client client, Ticket ticket) {
        Log.d(TAG,"onForceLogOut");
    }
}
