package com.example.socket.im.client;

import com.example.socket.im.vo.Constant;
import com.example.socket.im.vo.Message;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;

public abstract class ConnectThread {
    protected boolean isStopGetOffline = false;
    private int type;
    private Client client;
    private String currentServer;
    protected int mRetryCount = 0;
    private SSLSocket socket;
//    private Socket socket;
    public static final int maxLength = Constant.MESSAGE_BODY_MAX_LENGTH;
    public static IClientLogger erlLogger = ClientFactory.getLogger();
    private boolean isAccessDenied = false;
    protected boolean stoped = false;
    protected static int MaxRetryConnectCount = 20;
    TrustManager[] trustAllCerts = new TrustManager[] {
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
                public void checkClientTrusted(
                        X509Certificate[] certs, String authType) {
                }
                public void checkServerTrusted(
                        X509Certificate[] certs, String authType) {
                }
            }
    };

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCurrentServer() {
        return this.currentServer;
    }

    public boolean isAccessDenied() {
        return isAccessDenied;
    }
    // 读之前，先读4个字节包长数据
    public Packet recvPacket(int timeout) {
        if (timeout <= 0)
            return null;
        if (!isConnected() && !doHandShake()) {
            return null;
        }
        try {
            socket.setSoTimeout(timeout);
            Packet p = read(socket.getInputStream());
            if (null == p) {
                //如果未超时返回，并且packet是空的则使线程睡眠timeout然后进行连接重置
                //未超时表示连接已经失效
                Thread.sleep(timeout);

                disconnect(); //连接重置，socket假连接
            }
            return p;
        } catch (SocketException e1) {
            if (erlLogger.isDebugEnabled())
                erlLogger.debug(e1);
            disconnect();  //socket 发生异常进行连接重置
            return null;
        } catch (SocketTimeoutException e2) {
            //超时没关系
            return null;
        } catch (IOException e3) {
            if (erlLogger.isDebugEnabled())
                erlLogger.debug(e3);
            return null;
        } catch (Exception e4) {
            if (erlLogger.isDebugEnabled())
                erlLogger.debug(e4);
            return null;
        }
    }
    /**
     * 接收消息并解包
     * @param in
     * @return
     */
    private Packet read(InputStream in) throws IOException {
        int b1 = in.read();
        int b2 = in.read();
        int b3 = in.read();
        int b4 = in.read();
        if (b1 == -1 || b2 == -1 || b3 == -1 || b4 == -1) {
            return null;
        }
        int len = readFourInt(b1, b2, b3, b4);
        while (len < 7 || len > maxLength) {
            b1 = b2;
            b2 = b3;
            b3 = b4;
            b4 = in.read();
            if (b1 == -1 || b2 == -1 || b3 == -1 || b4 == -1) {
                return null;
            }
            len = readFourInt(b1, b2, b3, b4);
        }
        if (len >= 7 && len < maxLength) {
            byte[] data = new byte[len];
            in.read(data);
            Packet p = PacketUtil.unpack(data);
            if (null != p) {
                return p;
            } else {
                return read(in);
            }
        }
        return null;
    }

    /**
     * 支持 host = "192.168.1.100:2010"
     * @param host
     * @param timeout
     * return boolean
     */
    public boolean connect(String host, int timeout) {
        String[] strs = host.split(":");
        String ip = strs[0];
        int port = Integer.parseInt(strs[1]);
        if (ip == null || "".equals(ip))
            throw new RuntimeException("ip is empty!");
        if (port <= 0)
            throw new RuntimeException("port " + port + " definition error!");
        if (timeout <= 0)
            throw new RuntimeException("timeout " + timeout
                    + " definition error!");

//        socket = new Socket();
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            socket = (SSLSocket) sc.getSocketFactory().createSocket(ip, port);
//            InetSocketAddress addr = new InetSocketAddress(ip, port);
//            socket.connect(addr, timeout);
            socket.setSoTimeout(timeout);
            socket.setTcpNoDelay(true);
            socket.setKeepAlive(true);
            socket.setSoLinger(true, 0);
            return true;
        } catch (SocketException e) {
            getClient().getEvent().onConnectFail(getClient());
        } catch (Exception eu) {
            if (erlLogger.isDebugEnabled())
                erlLogger.debug(eu);
            disconnect();
        }
        return false;
    }

    // 发送前加4个字节包长
    public boolean send(byte[] bytes, int timeout) {
        if (socket == null || bytes == null || bytes.length == 0 || timeout <= 0)
            return false;
        try {
            socket.setSoTimeout(timeout);
            socket.getOutputStream().write(convertFourBytes(bytes.length));
            socket.getOutputStream().write(bytes);
            socket.getOutputStream().flush();
            return true;
        } catch (SocketException e) {
            getClient().getEvent().onConnectFail(getClient());
        } catch (Exception e) {
            if (erlLogger.isDebugEnabled())
                erlLogger.debug(e);
        }
        return false;
    }
    /**
     * 发送cmd
     * @param cmd
     * @return
     */
    public boolean send(int cmd) {
        Packet p = new Packet();
        p.setCmd(cmd);
        return send(p);
    }
    /**
     * 发送消息包
     * @param p
     * @return
     */
    public boolean send(Packet p) {
        if (!isConnected() && !doHandShake()) {
            return false;
        }
        if (send(PacketUtil.pack(p), getClient().getTcpSendTimeout())) {
            return true;
        }
        // 发送失败则关闭连接重试
        disconnect();
        return false;
    }
    /**
     * 和IM服务做handshake操作
     * @return true 成功 or false 失败
     */
    public boolean doHandShake() {
        currentServer = getClient().getLoginServers().getNext(getClient().getToken());
        if (null != currentServer) {  //尝试连接IM服务
            while (!connect(currentServer, getClient().getTcpConnectTimeout())) { //连接失败则重试
                mRetryCount++;
                currentServer = getClient().getLoginServers().getNext(getClient().getToken());
                try {
                    int sleepTime = getClient().getTcpTryConnectSleep();
                    if (mRetryCount > 6) {
                        sleepTime = getClient().getTcpTryConnectSleepSecondLevel();
                    }
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }

                if (mRetryCount >= MaxRetryConnectCount) {  //尝试重新连接服务超过MaxRetryConnectCount次，则停止线程
                    shutdown();
                    return false;
                }
            }
        } else {
            return false;
        }
        mRetryCount = 0;
        Ticket ticket = new Ticket();  //发送ticket做handshake
        ticket.setOs(getClient().getOs());
        ticket.setOsver(getClient().getOsVer());
        ticket.setToken(getClient().getToken());
        ticket.setUsername(getClient().getUser());
        ticket.setPassword(getClient().getPassword());
        ticket.setVer(getClient().getVer());
        ticket.setType(type);
        Packet pack = new Packet();
        pack.setCmd(Constant.CMD_LOGIN);
        pack.setObj(ticket);
        if (send(PacketUtil.pack(pack), getClient().getTcpSendTimeout())) {
            ticket = null;
            pack = null;
            pack = recvPacket(getClient().getTcpRecvTimeout());
            if (null != pack) {
                switch (pack.getCmd()) {
                    case Constant.RESPONSE_OK: {
                        getClient().getEvent().onLoginSuccess(getClient());
                        getClient().getEvent().onConnectSuccess(getClient());
                        return true;
                    }
                    case Constant.RESPONSE_ACCESS_DENIED: {
                        getClient().getEvent().onLoginAccessDenied(getClient());
                        isAccessDenied = true;
                        return false;
                    }
                    case Constant.CMD_FORCE_LOGOUT: {
                        getClient().getEvent().onForceLogOut(getClient(), ticket);
                        isAccessDenied = true;
                        return false;
                    }
                    default: {
                        getClient().getEvent().onLoginFail(getClient());
                        return false;
                    }
                }
            }
        } else {
            getClient().getEvent().onLoginFail(getClient());
        }
        getClient().getEvent().onConnectFail(getClient());
        return false;
    }

    /**
     * 发送获取离线消息的包
     * @return
     */
    public boolean sendGetOffline() {
        Message msg = Message.newMessage("");
        msg.setType(Constant.MESSAGE_TYPE_GET_OFFLINE);
        msg.setEcho(false);
        msg.setStore(false);
        Packet p = new Packet();
        p.setCmd(Constant.CMD_SEND_MESSAGE);
        p.setObj(msg);
        return send(p);
    }

    /**
     * 是否连接成功
     * @return
     */
    public boolean isConnected() {
        if (null == socket) {
            return false;
        }
        return socket.isConnected();
    }
    /**
     * 关闭连接
     */
    public void disconnect() {
        isStopGetOffline = false;
        try {
            if (null != socket) {
                socket.getInputStream().close();
                socket.getOutputStream().close();
            }
        }
        // 捕捉 SocketException added by Eric
        catch (SocketException e) {
            getClient().getEvent().onConnectFail(getClient());
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            socket = null;
        }
    }

    public byte[] convertFourBytes(int i) {
        byte[] b = new byte[4];
        b[0] = (byte) ((i & 0xff000000) >> 24);
        b[1] = (byte) ((i & 0xff0000) >> 16);
        b[2] = (byte) ((i & 0xff00) >> 8);
        b[3] = (byte) (i & 0xff);
        return b;
    }

    public int readFourInt(int b1, int b2, int b3, int b4)
    {
        return (((0x000000FF & b1) << 24) + ((0x000000FF & b2) << 16) + ((0x000000FF & b3) << 8) + (0x000000FF & b4));
    }

    public void shutdown() {
        mRetryCount = 0;
        if (!stoped) {
            stoped = true;
        }
    }

    public boolean isStoped() {
        return stoped;
    }
}
