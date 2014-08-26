package com.example.datastore.vo;

/**
 * @author TechBirds
 * @date 14-8-26
 * @time 下午1:47
 * @vsersion 1.0
 */
public class User {

    private int id;
    private String username;
    private String pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
