package com.example.socket.im.client;

import com.example.socket.im.vo.Message;

public interface IClientEvent {
    public final static String onLogin = "onLogin";
    public final static String onLoginAccessDenied = "onLoginAccessDenied";
    public final static String onLoginSuccess = "onLoginSuccess";
    public final static String onConnect = "onConnect";
    public final static String onConnectFail = "onConnectFail";
    public final static String onConnectSuccess = "onConnectSuccess";
    public final static String onLogout = "onLogout";
    public final static String onLogoutSuccess = "onLogoutSuccess";
    public final static String onSend = "onSend";
    public final static String onSendFail = "onSendFail";
    public final static String onSendSuccess = "onSendSuccess";
    public final static String onReceiveMessage = "onReceiveMessage";
    public final static String onReceiveMessageSuccess = "onReceiveMessageSuccess";
    public final static String onForceLogOut = "onForceLogOut";

    // 登录前
    public abstract void onLogin(Client client);

    // 登录时验证权限失败,该操作Client会处于wait状态
    public abstract void onLoginAccessDenied(Client client);

    // 登录失败后
    public abstract void onLoginFail(Client client);

    // 登录成功后
    public abstract void onLoginSuccess(Client client);

    // 连接前
    public abstract void onConnect(Client client);

    // 连接失败时
    public abstract void onConnectFail(Client client);

    // 连接成功后
    public abstract void onConnectSuccess(Client client);

    // 注销前
    public abstract void onLogout(Client client);

    // 注销后
    public abstract void onLogoutSuccess(Client client);

    // 发送前
    public abstract void onSend(Client client, Message message);

    // 发送失败后
    public abstract void onSendFail(Client client, Message message);

    // 发送成功后
    public abstract void onSendSuccess(Client client, Message message);

    // 当收到消息时
    public abstract void onReceiveMessage(Client client, Message message);

    // 当收完消息即向服务器发送过receiver ok后
    public abstract void onReceiveMessageSuccess(Client client, Message message);

    // 同步消息事件(web端或者客户端发送消息后同步)
    public abstract void onSyncSendMessage(Client client, Message message);

    public abstract void onForceLogOut(Client client, Ticket ticket);
}