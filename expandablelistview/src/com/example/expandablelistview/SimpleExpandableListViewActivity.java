package com.example.expandablelistview;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleExpandableListViewActivity extends ExpandableListActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_expandable);

        // 创建一级条目
        List<Map<String, String>> groups = new ArrayList<Map<String, String>>();
        //创建两个一级条目标题
        Map<String, String> group1 = new HashMap<String, String>();
        group1.put("group", "音乐");
        Map<String, String> group2 = new HashMap<String, String>();
        group2.put("group", "歌词");
        groups.add(group1);
        groups.add(group2);
        // 创建一级条目下的的二级条目
        List<Map<String, String>> child1 = new ArrayList<Map<String, String>>();
        //同样是在一级条目目录下创建两个对应的二级条目目录
        Map<String, String> childdata1 = new HashMap<String, String>();
        childdata1.put("child", "青花瓷");
        Map<String, String> childdata2 = new HashMap<String, String>();
        childdata2.put("child", "东风破");
        child1.add(childdata1);
        child1.add(childdata2);
        //同上
        List<Map<String, String>> child2 = new ArrayList<Map<String, String>>();
        Map<String, String> childdata3 = new HashMap<String, String>();
        childdata3.put("child", "青花瓷.lrc");
        Map<String, String> childdata4 = new HashMap<String, String>();
        childdata4.put("child", "东风破.lrc");
        child2.add(childdata3);
        child2.add(childdata4);
        // 将二级条目放在一个集合里，供显示时使用
        List<List<Map<String, String>>> childs = new ArrayList<List<Map<String, String>>>();
        childs.add(child1);
        childs.add(child2);
        /**
         * 使用SimpleExpandableListAdapter显示ExpandableListView
         * 参数1.上下文对象Context
         * 参数2.一级条目目录集合
         * 参数3.一级条目对应的布局文件
         * 参数4.fromto，就是map中的key，指定要显示的对象
         * 参数5.与参数4对应，指定要显示在groups中的id
         * 参数6.二级条目目录集合
         * 参数7.二级条目对应的布局文件
         * 参数8.fromto，就是map中的key，指定要显示的对象
         * 参数9.与参数8对应，指定要显示在childs中的id
         */
        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this, groups, R.layout.simple_group, new String[]{"group"},
                new int[]{R.id.group}, childs, R.layout.simple_child,
                new String[]{"child"}, new int[]{R.id.child});
        setListAdapter(adapter);


    }


    /**
     * 设置哪个二级目录被默认选中
     */
    @Override
    public boolean setSelectedChild(int groupPosition, int childPosition,
                                    boolean shouldExpandGroup) {
        //do something
        return super.setSelectedChild(groupPosition, childPosition,
                shouldExpandGroup);
    }

    /**
     * 设置哪个一级目录被默认选中
     */
    @Override
    public void setSelectedGroup(int groupPosition) {
        //do something
        super.setSelectedGroup(groupPosition);
    }

    /**
     * 当二级条目被点击时响应
     */
    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        return super.onChildClick(parent, v, groupPosition, childPosition, id);
    }
}
