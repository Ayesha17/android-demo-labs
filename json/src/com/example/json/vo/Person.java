package com.example.json.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author TechBirds
 * @date 14-12-30
 * @time 上午10:01
 * @vsersion 1.0
 */
public class Person {

    private int mId;
    private String mName;
    private int mAge;
    private Date mCreatedDate;

    public Person() {
    }

    public Person(int id, String name, int age, Date createdDate) {
        mId = id;
        mName = name;
        mAge = age;
        mCreatedDate = createdDate;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }

    public Date getCreatedDate() {
        return mCreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.mCreatedDate = createdDate;
    }
}
