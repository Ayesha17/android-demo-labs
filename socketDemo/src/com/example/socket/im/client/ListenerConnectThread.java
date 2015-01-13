package com.example.socket.im.client;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import com.example.socket.MainApplication;
import com.example.socket.im.receiver.EventReceiver;
import com.example.socket.im.vo.Constant;
import com.example.socket.im.vo.Message;
import com.example.socket.service.IMService;

/**
 * 监听接收者线程
 *
 * @author buqi
 */
public class ListenerConnectThread extends ConnectThread implements Runnable {

    private IClientLogger logger = ClientFactory.getLogger();
    private long lastReceiveServerTime = System.currentTimeMillis();
    private long idleTime = System.currentTimeMillis();
    private int idleMaxTime = 300000;   //如果5分钟内没有收到消息，则发送ping后使线程停止执行
    private int sleepTime = 15000;
    private boolean finished = false;
    private Context context;
    private AlarmManager alarmManager;

    public ListenerConnectThread() {
        this.context = MainApplication.getInstance();
        this.alarmManager = (AlarmManager) context
                .getSystemService(Context.ALARM_SERVICE);
    }

    @Override
    public void run() {
        Intent intent = new Intent(MainApplication.getInstance(),
                EventReceiver.class);
        intent.setAction(IMService.IMServiceAction.Ping.getName());
        PendingIntent pendingIntent = PendingIntent
                .getBroadcast(context, 0, intent, 0);

        alarmManager.cancel(pendingIntent);

        setFinished(false);
        stoped = false;

        while (!stoped) {
            execute();
        }

        setFinished(true);
        stoped = true;
        Log.d("tag", "listener is shutdown now because receive message timeout");
        long timeToWakeup = SystemClock.elapsedRealtime() + sleepTime;
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                timeToWakeup, pendingIntent);
    }

    private void execute() {
        if (isAccessDenied()) {
            Ticket tick = new Ticket();
            shutdown();
            getClient().getEvent().onForceLogOut(getClient(), tick);
            return;
        }
        try {
            Packet p = recvPacket(getClient().getTcpRecvTimeout());
            if (null != p) {
                // 收到包则时间复位
                resetIdle();
                if (Constant.CMD_RECEIVE_MESSAGE == p.getCmd()) {
                    Message message = (Message) p.getObj();
                    if (message.getType() == Constant.MESSAGE_TYPE_STOP_GET_OFFLINE) {
                        isStopGetOffline = true;
                        getClient().getLoginServers().addServers(message.getBody());  //添加其他服务进行容错
                    } else {
                        if (logger.isDebugEnabled())
                            logger.debug(getClient().getUser()
                                    + " : execute onReceiveMessage("
                                    + message.getId() + ")");
                        getClient().getEvent().onReceiveMessage(getClient(),
                                message);

                        Packet rp = PacketUtil.receiveOk(message.getId(), message.getType());
                        if (send(rp)) {
                            if (logger.isDebugEnabled())
                                logger.debug(getClient().getUser()
                                        + " : execute onReceiveMessageSuccess("
                                        + message.getId() + ")");
                            getClient().getEvent().onReceiveMessageSuccess(
                                    getClient(), message);
                        }
                        rp = null;
                    }

                } else if (Constant.CMD_FORCE_LOGOUT == p.getCmd()) {
                    Ticket tick = (Ticket) p.getObj();
                    getClient().getEvent().onForceLogOut(getClient(), tick); //需要该事件执行的时候强制执行logout操作，防止出现来回踢人状况
                } else if (Constant.CMD_SEND_MESSAGE == p.getCmd()) {   //触发同步消息事件
                    Message message = (Message) p.getObj();
                    Packet rp = PacketUtil.receiveOk(message.getId());
                    send(rp);
                    rp = null;
                    getClient().getEvent().onSyncSendMessage(getClient(), message);
                }
                p = null;
            } else if (null == p) {
                if (!isConnected()) {
                    // 什么都不做
                    Thread.sleep(getClient().getTcpTryConnectSleep());
                }
            } else {
                // 其他错误,连接复位
                disconnect();
            }
            checkIdleTimeout();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetIdle() {
        lastReceiveServerTime = System.currentTimeMillis();
        idleTime = lastReceiveServerTime;
    }

    public boolean checkIdleTimeout() {
        long now = System.currentTimeMillis();
        long use = now - lastReceiveServerTime;
        // 超出最大闲时间则发ping
        if (use > idleMaxTime) {
            if (logger.isDebugEnabled())
                logger.debug(getClient().getUser() + " : ping");
            if (send(Constant.CMD_PING) && !isStopGetOffline) {  //发送完ping包尝试获取离线消息
                sendGetOffline();  //该消息没有response
            }
            Packet p = recvPacket(getClient().getTcpRecvTimeout());
            if (null == p) {
                if (logger.isDebugEnabled())
                    logger.debug(getClient().getUser() + " : ping fail connect reset");
                disconnect();   //有可能连接失效，尝试重新连接
                return false;
            } else if (p.getCmd() == Constant.RESPONSE_OK) {
                if (logger.isDebugEnabled())
                    logger.debug(getClient().getUser() + " : ping success");
                resetIdle(); // 复位,避免重复发ping
            }
        }
        return true;
    }

    @Override
    public void disconnect() {
        // 复位时间，防止频繁重发
        resetIdle();
        super.disconnect();
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void cancelAlarm() {
        Intent intent = new Intent(MainApplication.getInstance(),
                EventReceiver.class);
        intent.setAction(IMService.IMServiceAction.Ping.getName());
        PendingIntent pendingIntent = PendingIntent
                .getBroadcast(context, 0, intent, 0);

        alarmManager.cancel(pendingIntent);
    }
}
