package com.example.socket.im.client;

import java.util.Arrays;

public class LoginServers {
    private String servers = "";
    private ConsistentHash hashring = new ConsistentHash(3);

    public LoginServers(String servers) {
        if (servers.startsWith("[")) {
            servers = servers.substring(1, servers.length() - 1);
        }
        setServers(servers);
    }

    public static void main(String[] args) {
        LoginServers servers4 = new LoginServers("192.168.1.1:1111,192.168.1.2.2222,127.0.0.1:2010");
        System.out.println(servers4.getNext(1));
        System.out.println(servers4.getNext(2));
        System.out.println(servers4.getNext(3));
        System.out.println(servers4.getNext(4));
        System.out.println(servers4.getNext(5));
        System.out.println(servers4.getNext(6));
    }

    public int getLength() {
        return hashring.size();
    }

    public String getNext(String key) {
        return hashring.get(key);
    }

    public String getNext(long key) {
        return hashring.get(key + "");
    }

    public String getNext(int key) {
        return hashring.get(key + "");
    }

    public String getServers() {
        return servers;
    }

    public void setServers(String servers) {
        this.servers = servers;
        if (null != servers && !"".equals(servers)) {
            hashring.addAll(Arrays.asList(servers.split(",")));
        }
    }

    public void addServers(String servers) {
        if (null != servers && !"".equals(servers)) {
            this.servers += "," + servers;
            hashring.addAll(Arrays.asList(servers.split(",")));
        }
    }
}
