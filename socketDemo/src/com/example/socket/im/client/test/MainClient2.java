/*   
 * Copyright (c) 2012-2013 Qeemo Ltd. All Rights Reserved.      
 *
 */
package com.example.socket.im.client.test;


import com.example.socket.im.client.Client;
import com.example.socket.im.client.ClientFactory;
import com.example.socket.im.vo.Message;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kurten
 * @version 1.0
 * @date 2013-10-31
 * @time 下午5:00:15
 */
public class MainClient2 {

    /**
     * @param args
     * @author kurten
     * //     * @time 2013-10-31 下午5:00:15
     */
    public static void main(String[] args) {
        ClientFactory factory = ClientFactory.getInstance("192.168.1.200:5222", new TestLogger());
        Client client2 = factory.getClient("18222222222", "", "fc5b40b61e4268bae15f523dcd6ffa5d", new TestClientEvent());
        client2.login();

        Client client = factory.getClient();
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (int i = 0; i < 2; i++) {
            Message msg = Message.newMessage(0, "你好吗" + i + " date:" + spf.format(new Date()));
            msg.setTo("480");
            client.send(msg,480);

            //不清出为何Thread.sleep会阻断第二次发送消息
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
    }

}
