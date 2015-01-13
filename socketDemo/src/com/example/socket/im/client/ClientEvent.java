package com.example.socket.im.client;

import com.example.socket.im.vo.Message;

/**
 * IClientEvent默认实现
 *
 * @author changgb
 */

public class ClientEvent implements IClientEvent {

    // 登录前
    /*
     * (non-Javadoc)
     *
     * @see
     * co.yun56.apps.lib.im.client.IClientEvent#onLogin(co.yun56.apps.lib.im.client.Client)
     */
    public void onLogin(Client client) {

    }

    // 登录失败后
    /*
     * (non-Javadoc)
     *
     * @see
     * co.yun56.apps.lib.im.client.IClientEvent#onLoginFail(co.yun56.apps.lib.im.client.Client
     * )
     */
    public void onLoginFail(Client client) {

    }

    // 登录成功后
    /*
     * (non-Javadoc)
     *
     * @see
     * co.yun56.apps.lib.im.client.IClientEvent#afterLogin(co.yun56.apps.lib.im.client.Client)
     */
    public void onLoginSuccess(Client client) {

    }

    // 连接前
    /*
     * (non-Javadoc)
     *
     * @see
     * co.yun56.apps.lib.im.client.IClientEvent#onConnect(co.yun56.apps.lib.im.client.Client)
     */
    public void onConnect(Client client) {
    }

    // 连接失败时
    /*
     * (non-Javadoc)
     *
     * @see
     * co.yun56.apps.lib.im.client.IClientEvent#onConnectFail(co.yun56.apps.lib.im.client.
     * Client)
     */
    public void onConnectFail(Client client) {
    }

    // 连接成功后
    /*
     * (non-Javadoc)
     *
     * @see
     * co.yun56.apps.lib.im.client.IClientEvent#afterConnect(co.yun56.apps.lib.im.client.Client
     * )
     */
    public void onConnectSuccess(Client client) {

    }

    // 注销前
    /*
     * (non-Javadoc)
     *
     * @see
     * co.yun56.apps.lib.im.client.IClientEvent#onLogout(co.yun56.apps.lib.im.client.Client)
     */
    public void onLogout(Client client) {

    }

    // 注销后
    /*
     * (non-Javadoc)
     *
     * @see
     * co.yun56.apps.lib.im.client.IClientEvent#afterLogout(co.yun56.apps.lib.im.client.Client
     * )
     */
    public void onLogoutSuccess(Client client) {

    }

    // 发送前
    /*
     * (non-Javadoc)
     *
     * @see
     * co.yun56.apps.lib.im.client.IClientEvent#onSend(co.yun56.apps.lib.im.client.Client,
     * co.yun56.apps.lib.im.vo.Message)
     */
    public void onSend(Client client, Message message) {

    }

    // 发送失败后
    /*
     * (non-Javadoc)
     *
     * @see
     * co.yun56.apps.lib.im.client.IClientEvent#onSendFail(co.yun56.apps.lib.im.client.Client,
     * co.yun56.apps.lib.im.vo.Message)
     */
    public void onSendFail(Client client, Message message) {

    }

    // 发送成功后
    /*
     * (non-Javadoc)
     *
     * @see
     * co.yun56.apps.lib.im.client.IClientEvent#afterSend(co.yun56.apps.lib.im.client.Client,
     * co.yun56.apps.lib.im.vo.Message)
     */
    public void onSendSuccess(Client client, Message message) {

    }

    // 当收到消息时
    /*
     * (non-Javadoc)
     *
     * @see
     * co.yun56.apps.lib.im.client.IClientEvent#onReceiveMessage(co.yun56.apps.lib.im.client
     * .Client, co.yun56.apps.lib.im.vo.Message)
     */
    public void onReceiveMessage(Client client, Message message) {

    }

    // 当收完消息即向服务器发送过receiver ok后
    /*
     * (non-Javadoc)
     *
     * @see
     * co.yun56.apps.lib.im.client.IClientEvent#afterReceiverMessage(com.lianpu.im.
     * client.Client, co.yun56.apps.lib.im.vo.Message)
     */
    public void onReceiveMessageSuccess(Client client, Message message) {

    }

    @Override
    public void onSyncSendMessage(Client client, Message message) {

    }

    @Override
    public void onLoginAccessDenied(Client client) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onForceLogOut(Client client, Ticket ticket) {
        // TODO Auto-generated method stub

    }

}
