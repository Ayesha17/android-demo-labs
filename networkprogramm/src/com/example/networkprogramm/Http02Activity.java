package com.example.networkprogramm;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TechBirds
 * @date 14-8-12
 * @time 下午2:48
 * @vsersion 1.0
 */
public class Http02Activity extends Activity implements View.OnClickListener{


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
                    Toast.makeText(Http02Activity.this, "请求失败", Toast.LENGTH_SHORT).show();
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
                sendHttpClient();
                break;

            default:
                break;

        }

    }

    public void sendHttpClient(){

        new Thread(new Runnable() {
            @Override
            public void run() {

                HttpClient httpClient = new DefaultHttpClient();

                // GET
                HttpGet httpGet = new HttpGet("http://www.baidu.com");

                // POST
                HttpPost httpPost = new HttpPost("http://www.baidu.com");


                try {

                    // POST
//                    List<NameValuePair> params = new ArrayList<NameValuePair>();
//                    params.add(new BasicNameValuePair("username","admin"));
//                    params.add(new BasicNameValuePair("password","123456"));
//                    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"UTF-8");
//                    httpPost.setEntity(entity);
//                    httpClient.execute(httpPost);


                    HttpResponse httpResponse = httpClient.execute(httpGet);
                    if(httpResponse.getStatusLine().getStatusCode() == 200){
                        // OK
                        HttpEntity httpEntity = httpResponse.getEntity();
                        String response = EntityUtils.toString(httpEntity);

                        Message message = new Message();
                        message.what = Constant.SHOW_RESPONSE;
                        message.obj = response.toString();
                        handler.sendMessage(message);

                    }else{
                        Message message = new Message();
                        message.what = Constant.SHOW_ERROR;
                        handler.sendMessage(message);
                    }

                } catch (IOException e) {
                    e.printStackTrace();

                    Message message = new Message();
                    message.what = Constant.SHOW_ERROR;
                    handler.sendMessage(message);
                }

            }
        }).start();

    }

}
