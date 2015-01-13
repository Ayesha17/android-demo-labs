/*   
 * Copyright (c) 2012-2013 Qeemo Ltd. All Rights Reserved.      
 *
 */
package com.example.socket.im.client.test;


import com.example.socket.im.client.Client;
import com.example.socket.im.client.ClientFactory;

import java.text.SimpleDateFormat;

/**
 * @author kurten
 * @version 1.0
 * @date 2013-10-31
 * @time 下午5:00:15
 */
public class MainClient {

    /**
     * @param args
     * @author kurten
     * @time 2013-10-31 下午5:00:15
     */
    public static void main(String[] args) {
        ClientFactory factory = ClientFactory.getInstance("192.168.1.200:3000", new TestLogger());
        Client client1 = factory.getClient("15658425566", "", "d1c2b767d98f9eef97d7f0a8936ae375", new TestClientEvent());
        client1.login();
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        for (int i = 0; i < 10; i++) {
//            Message msg = Message.newMessage(0, "你雷克萨江东父老好吗=" + i + " date:" + spf.format(new Date()));
//            msg.setTo("403");
//            client1.send(msg);
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }
}
