package com.example.networkprogramm;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author TechBirds
 * @date 14-8-12
 * @time 下午2:48
 * @vsersion 1.0
 */
public class Http03Activity extends Activity implements View.OnClickListener{

    private Button reqBtn;
    private TextView resTv;

    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what){

                case Constant.SHOW_RESPONSE:
                    String response = (String)msg.obj;
                    resTv.setText(response);
                    break;
                case Constant.SHOW_ERROR:
                    Toast.makeText(Http03Activity.this, "请求失败", Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_http_layout);

        reqBtn = (Button) findViewById(R.id.reqBtn);
        resTv = (TextView) findViewById(R.id.resTv);

        reqBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.reqBtn :

                HttpUtil.sendHttpRequest("http://www.baidu.com",new HttpUtil.HttpCallbackListener() {
                    @Override
                    public void onFinish(String response) {

                        Message message = new Message();
                        message.what = Constant.SHOW_RESPONSE;
                        message.obj = response;
                        handler.sendMessage(message);

                    }

                    @Override
                    public void onError(Exception e) {

                        Message message = new Message();
                        message.what = Constant.SHOW_ERROR;
                        handler.sendMessage(message);

                    }
                });
                break;

            default:
                break;

        }


    }
}
