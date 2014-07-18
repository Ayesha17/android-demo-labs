package com.example.viewpager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author TechBirds
 * @date 14-7-18
 * @time 上午10:29
 * @vsersion 1.0
 */
public class GirlFragment extends Fragment{


    private int resId;

    public GirlFragment(int resId) {
        this.resId = resId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.girl_fragment_layout,container,false);

        ImageView vGuide = (ImageView)view.findViewById(R.id.guide_iv);
        vGuide.setImageResource(resId);

        return view;
    }
}
