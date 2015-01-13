/*   
 * Copyright (c) 2012-2013 Qeemo Ltd. All Rights Reserved.      
 */
package com.example.socket.im.vo;

import java.io.Serializable;

/**
 * @author Kurten
 * @date 14-3-21
 * @time 下午3:57
 * @vsersion 1.0
 */
public class Id implements Serializable {

    private static final long serialVersionUID = 5050984927432745342L;
    public Id() { this(""); }
    public Id(String id) {
        this.id = id;
    }
    private String id = "";
    private int type = Constant.CMD_RECEIVE_MESSAGE;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
