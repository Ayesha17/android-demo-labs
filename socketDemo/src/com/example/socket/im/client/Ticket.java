package com.example.socket.im.client;

import java.io.Serializable;

/**
 * 建立connect所需要的"票"
 *
 * @author buqi
 * @version 1.0 2011-6-20
 */
public class Ticket implements Serializable {
    private static final long serialVersionUID = -5988125765925914420L;
    String token = "";
    int type = 0;
    String ip = "127.0.0.1";
    int port = 0;
    long time = 0;
    long validtime = 0;
    String username = "";
    String os = "";
    String osver = "";
    String password = "";
    String ver = "";

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getValidtime() {
        return validtime;
    }

    public void setValidtime(long validtime) {
        this.validtime = validtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsver() {
        return osver;
    }

    public void setOsver(String osver) {
        this.osver = osver;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(token);
        sb.append(",");
        sb.append(type);
        sb.append(",");
        sb.append(ip);
        sb.append(",");
        sb.append(port);
        sb.append(",");
        sb.append(time);
        sb.append(",");
        sb.append(os);
        sb.append(",");
        sb.append(osver);
        sb.append(",");
        sb.append(validtime);
        return sb.toString();
    }

    @Override
    public Ticket clone() {
        Ticket newTicket = new Ticket();
        newTicket.setIp(this.ip);
        newTicket.setPort(this.port);
        newTicket.setToken(token);
        newTicket.setTime(this.time);
        newTicket.setType(this.type);
        newTicket.setUsername(this.username);
        newTicket.setValidtime(this.validtime);
        newTicket.setOs(this.os);
        newTicket.setOsver(this.osver);
        return newTicket;
    }
}
