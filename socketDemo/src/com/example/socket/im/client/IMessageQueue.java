package com.example.socket.im.client;

import com.example.socket.im.vo.Message;

/**
 * 消息队列 (先入先出)
 *
 * @author changgb
 */
public interface IMessageQueue {

    /**
     * 追加一条新的消息
     *
     * @param newMessage
     * @return
     */
    public boolean addMessage(Message newMessage);

    /**
     * 返回队列中第一条消息
     *
     * @return
     */
    public Message getMessage();

    /**
     * 把队列中第一条消息去除
     *
     * @return
     */
    public boolean removeMessage(Message newMessage);

    public void close();

}
