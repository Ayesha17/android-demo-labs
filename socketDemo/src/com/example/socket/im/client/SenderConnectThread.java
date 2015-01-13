package com.example.socket.im.client;

import com.example.socket.im.vo.Constant;
import com.example.socket.im.vo.Message;

public class SenderConnectThread extends ConnectThread implements Runnable {
    private final MessageQueue queue = new MessageQueue();
    private IClientLogger logger = ClientFactory.getLogger();

    @Override
    public void run() {
        executeSimple();
    }

    private void executeSimple(){
        while (true){
            Message message = queue.getMessage();
            int tryCount = 2;
            sendMessage(message, tryCount);
        }
    }

    private void executeComplex(){
        stoped = false;
        while (!stoped) {
            execute();
        }
        stoped = true;
    }

    private void execute() {
        if (isAccessDenied()) {
            shutdown();
            return;
        }
        try {
            boolean bSent = false;
            Message message = null;
            message = this.queue.getMessage();
            if (null != message) {
                if (logger.isDebugEnabled())
                    logger.debug(getClient().getUser() + " : execute onSend(" + message.getId() + ")");
                getClient().getEvent().onSend(getClient(), message);

                bSent = sendMessage(message, getClient().getSenderTrySendCount());

                if (bSent) {
                    if (logger.isDebugEnabled())
                        logger.debug(getClient().getUser() + " : execute onSendSuccess(" + message.getId() + ")");
                    getClient().getEvent().onSendSuccess(getClient(), message);
                } else {
                    if (logger.isDebugEnabled())
                        logger.debug(getClient().getUser() + " : execute onSendFail(" + message.getId() + ")");
                    getClient().getEvent().onSendFail(getClient(), message);
                    disconnect();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (this.queue.size() == 0) {
            shutdown();
        }
    }

    private boolean sendMessage(Message message, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            if (sendMessage(message)) {
                return true;
            }
        }
        return false;
    }

    private boolean sendMessage(Message message) {
        if (logger.isDebugEnabled()) logger.debug("send message " + message);

        Packet p = new Packet();
        p.setCmd(Constant.CMD_SEND_MESSAGE);
        p.setObj(message);

        if (send(p)) {
            p = null;
            if (message.isEcho()) {
                Packet rp = recvPacket(getClient().getTcpRecvTimeout());
                if (rp != null && Constant.RESPONSE_OK == rp.getCmd()) {
                    if (null != rp.getObj()) {
                        Message resp = (Message) rp.getObj();
                        message.setId(resp.getId());   //发送成功返回message id
                        resp = null;
                    }
                    rp = null;
                    if (logger.isDebugEnabled()) logger.debug("send message " + message.getId() + " success.");
                    return true;
                } else {
                    //如果发送消息没有收到回包则 sender 和 listener 都进行连接重置
                    disconnect();

                    rp = null;
                }
            } else {
                return true;
            }
        }

        if (logger.isDebugEnabled()) logger.debug("send message " + message.getId() + " fail.");

        return false;
    }

    public boolean pushMessage(Message m) {
        return queue.addMessage(m);
    }

    public int getBufferSize() {
        return queue.size();
    }
}
