package com.example.socket.im.client;

public interface IClientLogger {

    public boolean isDebugEnabled();

    public void info(Object message);

    public void debug(Object message);

    public void error(Object message);

}
