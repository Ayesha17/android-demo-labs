package com.example.photowallfallsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

/**
 * @author TechBirds
 * @date 14-8-20
 * @time 上午7:23
 * @vsersion 1.0
 */

public class ImageLoadTestActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.act_test);

        ImageView imageView = (ImageView)findViewById(R.id.test_iv);

        imageView.setImageBitmap(ImageLoader.decodeSampledBitmapFromResource(getResources(),R.drawable.page01,200,0));




    }
}
