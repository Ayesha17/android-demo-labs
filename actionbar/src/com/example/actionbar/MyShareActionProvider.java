package com.example.actionbar;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/**
 * @author TechBirds
 * @date 14-7-21
 * @time 下午5:42
 * @vsersion 1.0
 */
public class MyShareActionProvider extends ActionProvider {

    public MyShareActionProvider(Context context) {
        super(context);
    }

    @Override
    public View onCreateActionView() {
        return null;
    }

    @Override
    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        subMenu.add("sub item 1").setIcon(R.drawable.ic_launcher)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return true;
                    }
                });
        subMenu.add("sub item 2").setIcon(R.drawable.ic_launcher)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return false;
                    }
                });
    }

    @Override
    public boolean hasSubMenu() {
        return true;
    }
}
