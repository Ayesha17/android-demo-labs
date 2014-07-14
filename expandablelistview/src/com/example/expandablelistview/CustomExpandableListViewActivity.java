package com.example.expandablelistview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import com.example.expandablelistview.adapter.CustomExpandableListViewAdapter;
import com.example.expandablelistview.vo.Category;
import com.example.expandablelistview.vo.ItemDetail;

import java.util.ArrayList;
import java.util.List;

public class CustomExpandableListViewActivity extends Activity {

    private final static String TAG = "CustomExpandableListViewActivity";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_expandable);



        List<Category> categories = new ArrayList<Category>();

        Category category1 = new Category();
        category1.setId(1);
        category1.setName("group1");
        category1.setDesc("group1 desc");

        Category category2 = new Category();
        category2.setId(2);
        category2.setName("group2");
        category2.setDesc("group2 desc");

        List<ItemDetail> itemDetails = new ArrayList<ItemDetail>();
        List<ItemDetail> itemDetails1 = new ArrayList<ItemDetail>();

        ItemDetail itemDetail1 = new ItemDetail();
        itemDetail1.setId(1);
        itemDetail1.setName("item 1");
        itemDetail1.setDesc("item 1 desc");

        ItemDetail itemDetail2 = new ItemDetail();
        itemDetail2.setId(2);
        itemDetail2.setName("item 2");
        itemDetail2.setDesc("item 2 desc");


        ItemDetail itemDetail3 = new ItemDetail();
        itemDetail3.setId(3);
        itemDetail3.setName("item 3");
        itemDetail3.setDesc("item 3 desc");

        ItemDetail itemDetail4 = new ItemDetail();
        itemDetail4.setId(4);
        itemDetail4.setName("item 4");
        itemDetail4.setDesc("item 4 desc");

        itemDetails.add(itemDetail1);
        itemDetails.add(itemDetail2);

        itemDetails1.add(itemDetail3);
        itemDetails1.add(itemDetail4);

        category1.setItemDetails(itemDetails);
        category2.setItemDetails(itemDetails1);

        categories.add(category1);
        categories.add(category2);

        ExpandableListView expandableListView = (ExpandableListView)findViewById(R.id.custom_expandable_list_view);

        // 去除系统自带的图标
        expandableListView.setGroupIndicator(null);

        CustomExpandableListViewAdapter customExpandableListViewAdapter = new CustomExpandableListViewAdapter(categories,this);
        expandableListView.setAdapter(customExpandableListViewAdapter);


        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

                Log.d(TAG,TAG);

                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long l) {

                Log.d(TAG,TAG);

                return false;
            }
        });




    }


}
