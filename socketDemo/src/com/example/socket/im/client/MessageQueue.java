package com.example.socket.im.client;


import com.example.socket.im.vo.Message;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue implements IMessageQueue {

    private BlockingQueue<Message> messageQueue;

    public MessageQueue() {
        messageQueue = new LinkedBlockingQueue<Message>();
    }

    public boolean addMessage(Message message) {
        return messageQueue.offer(message);
    }

    public Message getMessage() {
        try {
            return messageQueue.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean removeMessage(Message message) {
        return messageQueue.remove(message);
    }

    public void close() {
        messageQueue.clear();
    }

    public int size() {
        return messageQueue.size();
    }
}
