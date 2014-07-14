package com.example.expandablelistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.example.expandablelistview.R;
import com.example.expandablelistview.vo.Category;
import com.example.expandablelistview.vo.ItemDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TechBirds
 * @date 14-7-14
 * @time 上午11:29
 * @vsersion 1.0
 */
public class CustomExpandableListViewAdapter extends BaseExpandableListAdapter {

    private Context ctx;
    private List<Category> categories = new ArrayList<Category>();


    public CustomExpandableListViewAdapter(List<Category> categories,Context ctx) {
        this.categories = categories;
        this.ctx = ctx;
    }

    @Override
    public int getGroupCount() {
        return categories.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return categories.get(groupPosition).getItemDetails().size();
    }

    @Override
    public Category getGroup(int groupPosition) {
        return categories.get(groupPosition);
    }

    @Override
    public ItemDetail getChild(int groupPosition, int childPosition) {
        return categories.get(groupPosition).getItemDetails().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater)ctx.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.custom_group, parent, false);
        }

        TextView groupName = (TextView) v.findViewById(R.id.groupName);
        TextView groupDesc = (TextView) v.findViewById(R.id.groupDesc);
        final CheckBox groupCheck = (CheckBox)v.findViewById(R.id.groupCheck);


        groupCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<ItemDetail> itemDetails = getGroup(groupPosition).getItemDetails();

                for (ItemDetail itemDetail : itemDetails){
                    itemDetail.setChecked(groupCheck.isChecked());
                }

                getGroup(groupPosition).setChecked(groupCheck.isChecked());

                notifyDataSetChanged();
            }
        });

        Category category = categories.get(groupPosition);

        groupName.setText(category.getName());
        groupDesc.setText(category.getDesc());
        groupCheck.setChecked(category.isChecked());

        return v;

    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater)ctx.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.custom_child, parent, false);
        }

        TextView itemName = (TextView) v.findViewById(R.id.itemName);
        TextView itemDesc = (TextView) v.findViewById(R.id.itemDesc);
        final CheckBox itemCheck = (CheckBox) v.findViewById(R.id.itemCheck);


        itemCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ItemDetail itemDetail = getChild(groupPosition,childPosition);
                itemDetail.setChecked(itemCheck.isChecked());

                getGroup(groupPosition).setChecked(isChildrenChecked(groupPosition));

                notifyDataSetChanged();

            }
        });

        ItemDetail itemDetail = categories.get(groupPosition).getItemDetails().get(childPosition);

        itemName.setText(itemDetail.getName());
        itemDesc.setText(itemDetail.getDesc());
        itemCheck.setChecked(itemDetail.isChecked());

        return v;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    // 获取子元素的状态(true:全部选中,false:未全部选中)
    private boolean isChildrenChecked(int groupPosition){

        Category category = getGroup(groupPosition);
        List<ItemDetail> itemDetails = category.getItemDetails();

        boolean isChecked = true;


        for(ItemDetail itemDetail : itemDetails){

            if (!itemDetail.isChecked()){
                isChecked = false;
                break;
            }
        }

        return isChecked;
    }



}
