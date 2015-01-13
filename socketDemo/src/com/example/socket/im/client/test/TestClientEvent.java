package com.example.socket.im.client.test;

import com.example.socket.im.client.Client;
import com.example.socket.im.client.ClientEvent;
import com.example.socket.im.vo.Message;

public class TestClientEvent extends ClientEvent {
    @Override
    public void onConnectSuccess(Client client) {
        System.out.println(client.getUser() + " : after connect");
    }

    @Override
    public void onLoginSuccess(Client client) {
        System.out.println(client.getUser() + " : after login");
    }

    @Override
    public void onLogoutSuccess(Client client) {
        System.out.println(client.getUser() + " : after logout");
    }

    @Override
    public void onSendSuccess(Client client, Message message) {
        System.out.println(client.getUser() + " : after send");
    }

    @Override
    public void onConnect(Client client) {
        System.out.println(client.getUser() + " : on connect");
    }

    @Override
    public void onConnectFail(Client client) {
        System.out.println(client.getUser() + " : on connectfail");
    }

    @Override
    public void onLogin(Client client) {
        System.out.println(client.getUser() + " : on login");
    }

    @Override
    public void onLoginFail(Client client) {
        System.out.println(client.getUser() + " : on login fail");
    }

    @Override
    public void onLogout(Client client) {
        System.out.println(client.getUser() + " : on logout");
        client.logout();
    }

    @Override
    public void onReceiveMessage(Client client, Message message) {
        System.out.println(client.getUser() + " on receive message from " + message.getSender() + "--" + message.getBody());
    }

    @Override
    public void onSend(Client client, Message message) {
    }

    @Override
    public void onSendFail(Client client, Message message) {
        // TODO Auto-generated method stub
        super.onSendFail(client, message);
    }

    // 当收完消息即向服务器发送过receiver ok后
    /*
     * (non-Javadoc)
	 * 
	 * @see
	 * co.yun56.apps.lib.im.client.IClientEvent#afterReceiverMessage(co.yun56.apps.lib.im.client
	 * .Client, co.yun56.apps.lib.im.vo.Message)
	 */
    public void onReceiveMessageSuccess(Client client, Message message) {
        System.out.println(client.getUser() + " : receive " + message);
    }

    @Override
    public void onSyncSendMessage(Client client, Message message) {
        System.out.println(client.getUser() + " onSyncSendMessage from " + message.getSender() + "--" + message.getReceiver() + "--" + message.getBody());
    }

    @Override
    public void onLoginAccessDenied(Client client) {
        System.out.println("login access denied");
        client.logout();
    }

}
