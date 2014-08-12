package com.example.networkprogramm;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * @author TechBirds
 * @date 14-8-12
 * @time 下午2:48
 * @vsersion 1.0
 */
public class Http01Activity extends Activity implements View.OnClickListener{




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
                    Toast.makeText(Http01Activity.this,"请求失败",Toast.LENGTH_SHORT).show();
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

                sendRequestWithHttpURLConnection();

                break;

            default:
                break;

        }

    }

    public void sendRequestWithHttpURLConnection(){

        // 开启线程发起请求
        new Thread(new Runnable() {
            @Override
            public void run() {

                HttpURLConnection connection = null;

                try {
                    URL url = new URL("http://www.baidu.com");
                    connection = (HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");

                    // POST
//                    connection.setRequestMethod("POST");
//                    DataOutputStream out = new DataOutputStream(connection.getOutputStream());
//                    out.writeBytes("username=admin&password=123456");

                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line ;
                    while((line = reader.readLine()) != null){
                        response.append(line);
                    }

                    Message message = new Message();
                    message.what = Constant.SHOW_RESPONSE;
                    message.obj = response.toString();
                    handler.sendMessage(message);

                } catch (Exception e) {
                    e.printStackTrace();

                    Message message = new Message();
                    message.what = Constant.SHOW_ERROR;
                    handler.sendMessage(message);

                }


            }
        }).start();

    }


}
