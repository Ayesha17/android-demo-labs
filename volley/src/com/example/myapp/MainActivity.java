package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity implements View.OnClickListener{

    private final static String TAG = "MainActivity";

    private Button bt01;
    private Button bt02;

    private RequestQueue requestQueue;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bt01 = (Button)findViewById(R.id.bt01);
        bt02 = (Button)findViewById(R.id.bt02);

        bt01.setOnClickListener(this);
        bt02.setOnClickListener(this);


        requestQueue = Volley.newRequestQueue(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.bt01:
                stringRequest01();
                break;
            case R.id.bt02:
                stringRequest02();
                break;


        }
    }


    // 不带参数
    public void stringRequest01(){

        StringRequest stringRequest = new StringRequest("http://m.weather.com.cn/data/101010100.html",new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG,response);
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG,error.getMessage(),error);
            }
        });

        requestQueue.add(stringRequest);

    }

    // 带参数
    public void stringRequest02(){


        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG,response);
            }
        };

        Response.ErrorListener errorListener= new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG,error.getMessage(),error);
            }
        };

        String url = "http://www.baidu.com";

        StringRequest stringRequest = new StringRequest(Request.Method.POST,url,listener,errorListener){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {


                Map<String, String> map = new HashMap<String, String>();
                map.put("username", "TechBirds");
                map.put("password", "123456");

                return map;
            }
        };

        requestQueue.add(stringRequest);

    }





}
