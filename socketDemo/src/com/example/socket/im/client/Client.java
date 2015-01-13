package com.example.socket.im.client;

import android.util.Log;
import com.example.socket.im.tool.UniqueIdGen;
import com.example.socket.im.vo.Constant;
import com.example.socket.im.vo.Message;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public final static int DEFAUT_TCP_RECEIVE_TIMEOUT = 3000;
    private int tcpRecvTimeout = DEFAUT_TCP_RECEIVE_TIMEOUT;
    private ClientFactory factory;
    private LoginServers loginServers;
    private String user;
    private String password;
    private String token;
    private IClientEvent event;
    // 超时时间
    private int tcpConnectTimeout = 3000;
    // 重试间隔3s
    private int tcpTryConnectSleep = 10000;
    private int tcpTryConnectSleepSecondLevel = 30000;
    private int tcpSendTimeout = 3000;
    private SenderConnectThread sender;
    private int senderBufferMaxSize = 200;
    private int senderTrySendCount = 3;
    private ListenerConnectThread listener;
    // 系统:android, ios
    private String os = "";
    // 系统版本
    private String osVer = "";
    // 软件版本
    private String ver = "";
    private ExecutorService senderService;
    private ExecutorService listenerService;

    protected Client(ClientFactory factory, String user, String password,
                     String token) {
        this.factory = factory;
        this.loginServers = factory.getLoginServers();
        this.user = user;
        this.password = password;
        this.token = token;
        this.senderService = Executors.newSingleThreadExecutor();
        this.listenerService = Executors.newSingleThreadExecutor();
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    /**
     * 登录
     *
     * @return
     */
    public boolean login() {
        if (sender == null) {
            sender = new SenderConnectThread();
            sender.setClient(this);
            sender.setType(Constant.TICK_TYPE_SEND);
            senderService.submit(sender);
        }
//        if (listener == null) {
//            listener = new ListenerConnectThread();
//            listener.setClient(this);
//            listener.setType(Constant.TICK_TYPE_LISTEN);
//            listenerService.submit(listener);
//        }
        return true;
    }

    /**
     * 登出
     *
     * @return
     */
    public boolean logout() {
        if (sender != null) {
            sender.shutdown();
            sender.disconnect();
            sender = null;
        }
        if (listener != null) {
            listener.cancelAlarm();
            listener.shutdown();
            listener.disconnect();
            listener = null;
        }
        factory.freeClient(user);
        try {
            senderService.shutdownNow();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            listenerService.shutdownNow();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 检查接收和发送线程是否正在运行
     */
    public void check() {
//        if (!UserController.getInstance().isLoggedIn()) {
//            return;
//        }
        if (null != sender &&
                null != listener) {
            if (sender.isAccessDenied() ||
                    listener.isAccessDenied()) {
                return;
            }
            if (sender.isStoped()) {
                Log.d("tag", "client sender is stoped try resubmit sender");
                senderService.submit(sender);
            }
            if (listener.isStoped() && listener.isFinished()) {
                Log.d("tag", "client listener is stoped try resubmit listener");
                listenerService.submit(listener);
            }
        }
    }

    public boolean isOnline() {
        return listener.isConnected();
    }

    public boolean send(Message m,int userId) {
        if (m == null)
            throw new RuntimeException("message is empty!");
        //check();  //发送时表示正常操作，需要唤醒睡眠的listener线程
        m.setId(UniqueIdGen.nextId(userId));
        return sender.pushMessage(m);
    }

    public SenderConnectThread getSender() {
        return sender;
    }

    public ListenerConnectThread getListener() {
        return listener;
    }

    public IClientEvent getEvent() {
        return event;
    }

    protected void setEvent(IClientEvent event) {
        this.event = event;
    }

    public LoginServers getLoginServers() {
        return loginServers;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public int getTcpConnectTimeout() {
        return tcpConnectTimeout;
    }

    public int getTcpTryConnectSleep() {
        return tcpTryConnectSleep;
    }

    public int getTcpTryConnectSleepSecondLevel() {
        return tcpTryConnectSleepSecondLevel;
    }

    public int getTcpSendTimeout() {
        return tcpSendTimeout;
    }

    public int getTcpRecvTimeout() {
        return tcpRecvTimeout;
    }

    public int getSenderTrySendCount() {
        return senderTrySendCount;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsVer() {
        return osVer;
    }

    public void setOsVer(String osVer) {
        this.osVer = osVer;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
