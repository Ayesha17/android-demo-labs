package com.example.socket.im.client.test;

import com.example.socket.im.client.IClientLogger;

public class TestLogger implements IClientLogger {

    @Override
    public void debug(Object message) {
        String str = null;
        if (message instanceof String) {
            str = message.toString();
        } else {
            Exception ex = (Exception) message;
            str = ex.getMessage();
        }
    }

    @Override
    public void error(Object message) {
        String str = null;
        if (message instanceof String) {
            str = message.toString();
        } else {
            Exception ex = (Exception) message;
            str = ex.getMessage();
        }
    }

    @Override
    public void info(Object message) {
        String str = null;
        if (message instanceof String) {
            str = message.toString();
        } else {
            Exception ex = (Exception) message;
            str = ex.getMessage();
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

}
