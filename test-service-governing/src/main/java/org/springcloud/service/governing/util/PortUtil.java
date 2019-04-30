package org.springcloud.service.governing.util;

public class PortUtil {

    public static int RandomPort() {
        int port =  (int) (Math.random() * 60000 + 1);
        return port;
    }
}
