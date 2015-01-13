/*   
 * Copyright (c) 2012-2013 Qeemo Ltd. All Rights Reserved.      
 */
package com.example.socket.im.client.test;

import com.example.socket.im.client.Packet;
import com.example.socket.im.client.PacketUtil;
import com.example.socket.im.vo.Constant;
import com.example.socket.im.vo.Id;

/**
 * @author Kurten
 * @date 14-3-21
 * @time 下午3:34
 * @vsersion 1.0
 */
public class PacketTest {
    public static void main(String... args) {
//        Packet p = new Packet();
//        p.setCmd(111);
//        Message msg = Message.newMessage(11, "你好sadfa哈哈哈哈哈是大发牢骚的风景啊粮食店街法律手段会计法阿里斯顿就发了深刻的减肥啦上的纠纷啊束带结发路上的风景啊收到");
//        msg.setStore(false);
//        msg.setEcho(false);
//        msg.setEtime(12323L);
//        System.out.println(msg);
//        p.setObj(msg);
//
//
//        Packet ps = new Packet();
//        ps.unpack(p.pack());
//        System.out.println(ps.getCmd());
//        Message mm = (Message) ps.getObj();
//        System.out.println(mm.getBody());
//        System.out.println(mm.getEtime());
//        System.out.println(mm.isEcho());
//        System.out.println(mm.isStore());
//        System.out.println(mm.getBody().equals(msg.getBody()));

        Packet pp = new Packet();
        PacketUtil.receiveOk("asdfa2431asdfasdf");
        pp.setCmd(Constant.CMD_RECEIVE_OK);
        Packet pn = new Packet();
        Id ii = (Id) pn.getObj();
        System.out.println(ii.getId() + ii.getType());
    }
}
