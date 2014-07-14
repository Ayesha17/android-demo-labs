package com.example.expandablelistview.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TechBirds
 * @date 14-7-14
 * @time 上午11:24
 * @vsersion 1.0
 */
public class Category {

    private long id;
    private String name;
    private String desc;
    private boolean isChecked;

    private List<ItemDetail> itemDetails = new ArrayList<ItemDetail>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<ItemDetail> getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(List<ItemDetail> itemDetails) {
        this.itemDetails = itemDetails;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }
}
