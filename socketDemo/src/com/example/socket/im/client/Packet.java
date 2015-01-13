package com.example.socket.im.client;

import com.example.socket.im.vo.Constant;

/**
 * 通讯包类
 *
 * @author buqi
 * @version 1.0 2011-6-20
 */
public class Packet {

    private int ver = Constant.PROTOCOL_VERION;
    private int cmd = 0;
    private int usertag;
    private int systag = 1;
    private Object obj;

    public int getVer() {
        return ver;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }

    public int getCmd() {
        return cmd;
    }

    public void setCmd(int cmd) {
        this.cmd = cmd;
    }

    public int getUsertag() {
        return usertag;
    }

    public void setUsertag(int usertag) {
        this.usertag = usertag;
    }

    public int getSystag() {
        return systag;
    }

    public void setSystag(int systag) {
        this.systag = systag;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
