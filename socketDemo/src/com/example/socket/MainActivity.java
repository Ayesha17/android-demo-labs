package com.example.socket;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.socket.im.client.Client;
import com.example.socket.im.client.ClientFactory;
import com.example.socket.im.vo.Constant;
import com.example.socket.im.vo.Message;
import com.example.socket.service.IMService;

public class MainActivity extends Activity {

    private Button mSend;
    private TextView mMsg;
    private Button mStart;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mSend = (Button) findViewById(R.id.send);
        mMsg = (TextView) findViewById(R.id.msg);
        mStart = (Button) findViewById(R.id.start);

        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });

        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMService.actionStart(MainActivity.this);
            }
        });

    }

    private void send(){
        Client client = ClientFactory.getClient();
        Message message = Message.newMessage(0, "hello world");
        message.setType(Constant.MESSAGE_TYPE_USER);
        int userId = 480;
        message.setTo(userId + "");
        client.send(message,userId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        IMService.actionStop(this);
    }
}
