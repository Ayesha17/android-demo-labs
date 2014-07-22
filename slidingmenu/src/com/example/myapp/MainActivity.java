package com.example.myapp;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;

public class MainActivity extends SlidingActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("SlideMenu");
        // 设置内容布局
        setContentView(R.layout.content_layout);

        // 设置slideMenu布局
        setBehindContentView(R.layout.menu_layout);

        // fragment 管理
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.menu, new MenuFragment());
        fragmentTransaction.replace(R.id.content, new ContentFragment("Welcome"));
        fragmentTransaction.commit();

        // customize the SlidingMenu
        SlidingMenu sm = getSlidingMenu();
//        sm.setShadowWidth(10);
//        sm.setShadowDrawable(R.drawable.shadow);

        // 内容布局显示的宽度(单位:pixels)
        sm.setBehindOffset(300);

        // 渐变的速度
        sm.setFadeDegree(0.5f);
        //设置slding menu的几种手势模式
        //TOUCHMODE_FULLSCREEN 全屏模式，在content页面中，滑动，可以打开sliding menu
        //TOUCHMODE_MARGIN 边缘模式，在content页面中，如果想打开slding ,你需要在屏幕边缘滑动才可以打开slding menu
        //TOUCHMODE_NONE 自然是不能通过手势打开啦
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);

        //使用左上方icon可点，这样在onOptionsItemSelected里面才可以监听到R.id.home
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // toggle就是程序自动判断是打开还是关闭
                toggle();
//                getSlidingMenu().showMenu();// show menu
//                getSlidingMenu().showContent();//show content
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
