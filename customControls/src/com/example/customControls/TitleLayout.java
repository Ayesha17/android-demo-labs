package com.example.customControls;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * @author TechBirds
 * @date 14-8-25
 * @time 下午4:56
 * @vsersion 1.0
 */
public class TitleLayout extends LinearLayout {

    private View view;
    private Button prev;
    private Button next;

    public TitleLayout(Context context) {
        super(context);
    }

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.custom_title_layout,this);
        prev = (Button)view.findViewById(R.id.prev);
        next = (Button)view.findViewById(R.id.next);
    }

    public void setPrevClickListener(OnClickListener prevClickListener){
        prev.setOnClickListener(prevClickListener);
    }

    public void setNextClickListener(OnClickListener nextClickListener){
        next.setOnClickListener(nextClickListener);
    }

}
