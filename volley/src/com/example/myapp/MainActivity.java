package com.example.myapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.android.volley.*;
import com.android.volley.toolbox.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity implements View.OnClickListener {

    private final static String TAG = "MainActivity";

    private Button bt01;
    private Button bt02;
    private Button bt03;
    private Button bt04;
    private Button bt05;
    private Button bt06;
    private Button bt07;


    private ImageView avatarIv;
    private ImageView avatarIv02;
    private NetworkImageView networkImageView;

    private RequestQueue requestQueue;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bt01 = (Button) findViewById(R.id.bt01);
        bt02 = (Button) findViewById(R.id.bt02);
        bt03 = (Button) findViewById(R.id.bt03);
        bt04 = (Button) findViewById(R.id.bt04);
        bt05 = (Button) findViewById(R.id.bt05);
        bt06 = (Button) findViewById(R.id.bt06);
        bt07 = (Button) findViewById(R.id.bt07);

        avatarIv = (ImageView) findViewById(R.id.avatar_iv);
        avatarIv02 = (ImageView) findViewById(R.id.avatar_iv02);
        networkImageView = (NetworkImageView) findViewById(R.id.network_iv);


        bt01.setOnClickListener(this);
        bt02.setOnClickListener(this);
        bt03.setOnClickListener(this);
        bt04.setOnClickListener(this);
        bt05.setOnClickListener(this);
        bt06.setOnClickListener(this);
        bt07.setOnClickListener(this);


        requestQueue = Volley.newRequestQueue(this);

        // 6  networkImageView use step
        ImageLoader imageLoader = new ImageLoader(requestQueue, new BitmapCache());
        networkImageView.setDefaultImageResId(R.drawable.default_avatar);
        networkImageView.setErrorImageResId(R.drawable.default_avatar);
        networkImageView.setImageUrl("https://avatars2.githubusercontent.com/u/3411696?v=1&u=99bb4fbf59180e167fa607ad940c12d5dfa88733&s=140", imageLoader);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.bt01:
                stringRequest01();
                break;
            case R.id.bt02:
                stringRequest02();
                break;
            case R.id.bt03:
                jsonObjectRequest();
                break;
            case R.id.bt04:
                jsonArrayRequest();
                break;
            case R.id.bt05:
                imageRequest();
                break;
            case R.id.bt06:
                imageLoaderRequest();
                break;
            case R.id.bt07:
                gsonRequest();
                break;

        }
    }


    // 不带参数
    public void stringRequest01() {

        StringRequest stringRequest = new StringRequest("http://m.weather.com.cn/data/101010100.html", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.getMessage(), error);
            }
        }
        );

        requestQueue.add(stringRequest);

    }

    // 带参数
    public void stringRequest02() {


        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, response);
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.getMessage(), error);
            }
        };

        String url = "http://www.baidu.com";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, listener, errorListener) {

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

    public void jsonObjectRequest() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://m.weather.com.cn/data/101010100.html", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());

                        try {
                            Log.d(TAG, (response.getJSONObject("weatherinfo")).toString());
                        } catch (JSONException e) {
                            Log.e(TAG, e.getMessage(), e);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.getMessage(), error);
            }
        }
        );

        requestQueue.add(jsonObjectRequest);

    }

    public void jsonArrayRequest() {

        // 如果服务器返回的不是json数组，则解析会出错
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest("http://m.weather.com.cn/data/101010100.html",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, error.getMessage(), error);
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);

    }


    public void imageRequest() {

        // 1：url
        // 2：成功回掉
        // 3，4：预设高度宽度，如果为0，则不进行压缩
        // 5：像素占的字节数(ARGB_8888占四个字节，显示更好。RGB_565占2个字节)
        // 6：失败回掉
        ImageRequest imageRequest = new ImageRequest(
                "https://avatars2.githubusercontent.com/u/3411696?v=1&u=99bb4fbf59180e167fa607ad940c12d5dfa88733&s=140",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        avatarIv.setImageBitmap(response);
                    }
                }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.getMessage(), error);
                avatarIv.setImageResource(R.drawable.default_avatar);
            }
        }
        );

        requestQueue.add(imageRequest);

    }


    public void imageLoaderRequest() {

        ImageLoader imageLoader = new ImageLoader(requestQueue, new BitmapCache());


        ImageLoader.ImageListener listener = ImageLoader.getImageListener(avatarIv02,
                R.drawable.default_avatar, R.drawable.default_avatar);

        imageLoader.get("https://avatars2.githubusercontent.com/u/3411696?v=1&u=99bb4fbf59180e167fa607ad940c12d5dfa88733&s=140", listener);

    }

    // 自建缓存
    class BitmapCache implements ImageLoader.ImageCache {

        private LruCache<String, Bitmap> mCache;

        public BitmapCache() {

            // 缓存大小设置10M
            int maxSize = 10 * 1024 * 1024;

            mCache = new LruCache<String, Bitmap>(maxSize) {
                @Override
                protected int sizeOf(String key, Bitmap bitmap) {
                    return bitmap.getRowBytes() * bitmap.getHeight();
                }
            };
        }

        @Override
        public Bitmap getBitmap(String url) {
            return mCache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            mCache.put(url, bitmap);
        }

    }


    private void gsonRequest() {

        GsonRequest<Weather> gsonRequest = new GsonRequest<Weather>("http://m.weather.com.cn/data/101010100.html", Weather.class,
                new Response.Listener<Weather>() {
                    @Override
                    public void onResponse(Weather weather) {

                        WeatherInfo weatherInfo = weather.getWeatherinfo();
                        Log.d(TAG, "city is " + weatherInfo.getCity());
                        Log.d(TAG, "temp is " + weatherInfo.getTemp());
                        Log.d(TAG, "time is " + weatherInfo.getTime());

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.getMessage(), error);
            }
        }
        );

        requestQueue.add(gsonRequest);

    }

}
