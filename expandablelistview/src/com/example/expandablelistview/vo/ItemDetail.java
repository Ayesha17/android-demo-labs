package com.example.expandablelistview.vo;

/**
 * @author TechBirds
 * @date 14-7-14
 * @time 上午11:24
 * @vsersion 1.0
 */
public class ItemDetail {

    private long id;
    private int imgId;
    private String name;
    private String desc;
    private boolean isChecked;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
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

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }
}
