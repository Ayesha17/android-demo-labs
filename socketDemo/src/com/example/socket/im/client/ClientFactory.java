package com.example.socket.im.client;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Client工厂类
 *
 * @author changgb
 * @uses ClientFactory factory =
 * ClientFactory.getInstance("192.168.1.192:2010,192.168.1.194:2010");
 * Client client = factory.getClient("100000001", "100000001's pass");
 * client.send(..);
 */
public class ClientFactory {

    public static ClientFactory instance;

    // 所有的Client
    private Map<String, Client> clients = new HashMap<String, Client>();

    // 所有的LoginServer地址
    private LoginServers loginServers;

    private IClientLogger logger;

    private ClientFactory() { }

    public static IClientLogger getLogger() {
        if (instance == null)
            return new DefaultClientLogger();
        return instance.logger;
    }

    public static ClientFactory getInstance(String loginServers) {
        return getInstance(loginServers, new DefaultClientLogger());
    }

    public static synchronized ClientFactory getInstance(String loginServers,
                                                         IClientLogger logger) {
        if (instance == null) {
            LoginServers all = new LoginServers(loginServers);
            if (all.getLength() <= 0)
                throw new RuntimeException("loginServers is empty!");
            instance = new ClientFactory();
            instance.setLoginServers(all);
            instance.logger = logger;
        }
        return instance;
    }

    /**
     * 返回第一个Client, 在android应用中实际就是当前用户
     *
     * @return
     */
    public static Client getClient() {
        if (instance == null) {
            Log.d("tag", "instance null ");
            return null;
        }
        if (instance.clients == null || instance.clients.size() == 0) {
            Log.d("tag", "instance clients null ");
            return null;
        }
        for (String key : instance.clients.keySet()) {
            return instance.clients.get(key);
        }
        return null;
    }
    /**
     * 使用默认的ClientEvent处理
     *
     * @param user
     * @param password
     * @return
     */
    public Client getClient(String user, String password, String token) {
        return getClient(user, password, token, null);
    }

    public synchronized Client getClient(String user, String password,
                                         String token, IClientEvent event) {
        if (user == null || "".equals(user)) {
            Log.e("tag", "ClientFactory.getClient params user is empty!");
            return null;
        }
        if (token == null || "".equals(token)) {
            Log.e("tag", "ClientFactory.getClient params token is empty!");
            return null;
        }
        if (event == null) {
            Log.e("tag", "ClientFactory.getClient params event is empty!");
            return null;
        }

        Client client = clients.get(user);
        if (client == null) {
            client = new Client(this, user, password, token);
            // 如果event == null 建立各个默认的
            client.setEvent((event == null) ? new ClientEvent() : event);
            clients.put(user, client);
        }
        return client;
    }

    public LoginServers getLoginServers() {
        return loginServers;
    }

    private void setLoginServers(LoginServers newLoginServers) {
        this.loginServers = newLoginServers;
    }

    protected synchronized void freeClient(String user) {
        this.clients.remove(user);
    }

    public void destroy() {
        instance = null;
    }

}
