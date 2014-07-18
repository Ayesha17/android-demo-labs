package com.example.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {


    private GirlPageAdapter girlPageAdapter;
    private GirlPageChangerListener girlPageChangerListener;

    private TextView p1Tv,p2Tv,p3Tv;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        p1Tv = (TextView)findViewById(R.id.p1_tv);
        p2Tv = (TextView)findViewById(R.id.p2_tv);
        p3Tv = (TextView)findViewById(R.id.p3_tv);


        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new GirlFragment(R.drawable.guide1));
        fragments.add(new GirlFragment(R.drawable.guide2));
        fragments.add(new GirlFragment(R.drawable.guide3));

        girlPageAdapter = new GirlPageAdapter(getSupportFragmentManager());
        girlPageAdapter.setFragments(fragments);

        ViewPager viewPager = (ViewPager)findViewById(R.id.view_page);
        viewPager.setAdapter(girlPageAdapter);

        girlPageChangerListener = new GirlPageChangerListener();
        viewPager.setOnPageChangeListener(girlPageChangerListener);


    }

    private  class GirlPageAdapter extends FragmentPagerAdapter{

        private List<Fragment> fragments;

        public GirlPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }

        public void setFragments(List<Fragment> fragments) {
            this.fragments = fragments;
        }
    }

    class GirlPageChangerListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int i, float v, int i2) {

        }

        @Override
        public void onPageSelected(int position) {

            switch (position){

                case 0:

                    p1Tv.setTextColor(getResources().getColor(R.color.yellow));
                    p2Tv.setTextColor(getResources().getColor(R.color.white));
                    p3Tv.setTextColor(getResources().getColor(R.color.white));

                    break;
                case 1:

                    p1Tv.setTextColor(getResources().getColor(R.color.white));
                    p2Tv.setTextColor(getResources().getColor(R.color.yellow));
                    p3Tv.setTextColor(getResources().getColor(R.color.white));

                    break;
                case 2:

                    p1Tv.setTextColor(getResources().getColor(R.color.white));
                    p2Tv.setTextColor(getResources().getColor(R.color.white));
                    p3Tv.setTextColor(getResources().getColor(R.color.yellow));

                    break;
            }


        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }
}

