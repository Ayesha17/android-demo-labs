package com.example.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.main)
public class MainActivity extends Activity{

    @ViewById
    Button btn01;

    @ViewById
    Button btn02;

    @ViewById
    Button btn03;

    @ViewById
    Button btn10;

    @ViewById
    LinearLayout lay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Click
    void btn01() {
        LinearLayout.LayoutParams layParams = (LinearLayout.LayoutParams) btn01.getLayoutParams();
        layParams.height = 200; // px
        btn01.setLayoutParams(layParams);
    }

    @Click
    void btn02(){
        // 暂时没有提供动态设置layout_gravity的方法,但可设置gravity
//        layParams = (LinearLayout.LayoutParams) lay.getLayoutParams();
//        lay.setGravity(Gravity.RIGHT);
//        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) btn02.getLayoutParams();
//        layoutParams.gravity = Gravity.CENTER;
        btn02.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
    }

    @Click
    void btn03(){
        btn03.setBackgroundColor(Color.GREEN);
    }

    @Click
    void btn10(){
        MatrixActivity.actionStart(this);
    }




}
