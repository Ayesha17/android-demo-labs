package com.example.small;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * @author TechBirds
 * @date 14-9-24
 * @time 上午11:20
 * @vsersion 1.0
 */
public class Activity03 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act03);

        addView1();
        addView2();
    }

    /**
     * 特点：子元素本身套在一个布局里面，这样添加的时候不许要动态再去设置元素的布局。直接可在xml里进行完成。
     * 注意：建议使用
     */
    private void addView1(){
        // window decor view
        View view = getWindow().getDecorView();

        // FrameLayout root
        View root = view.findViewById(android.R.id.content);

        // Xml Root root
        LinearLayout xRoot = (LinearLayout)root.findViewById(R.id.root);

        // need to be added child
        View child = LayoutInflater.from(this).inflate(R.layout.child1,null);

        // do add
        xRoot.addView(child,0);

        // change margin
        setMargins(child,10,100,100,100);
    }

    /**
     * 特点: 子元素裸露，不套在一个布局里，需要动态修改其布局宽高
     */
    private void addView2(){
        // window decor view
        View view = getWindow().getDecorView();

        // FrameLayout root
        View root = view.findViewById(android.R.id.content);

        // Xml Root root
        LinearLayout xRoot = (LinearLayout)root.findViewById(R.id.root);

        // need to be added child
        View child = LayoutInflater.from(this).inflate(R.layout.child2,null);

        // 比较局限，且单位px(需要转换成dp)
        // xRoot.addView(child,200,100);

        // 同上，不过可以通过常量指定match,wrap,fill(已过时) example:ViewGroup.LayoutParams.MATCH_PARENT
        xRoot.addView(child,1,new ViewGroup.LayoutParams(200,100));

        setMargins(child,10,100,100,100);
    }


    /**
     * 动态改变margin
     * l,t,r,b : dp
     * @param v
     * @param l
     * @param t
     * @param r
     * @param b
     */
    public static void setMargins (View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }

}
