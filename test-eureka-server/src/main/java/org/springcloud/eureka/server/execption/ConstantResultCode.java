package org.springcloud.eureka.server.execption;

/**
* @Description:    java类作用描述
* @Author:         刘涛
* @CreateDate:     2019/4/22 18:17
*/

import jdk.internal.dynalink.beans.StaticClass;

import java.util.HashMap;
import java.util.Map;

public class ConstantResultCode {
    public static final Map<Integer, String> Message = new HashMap<>();
    public  static final Integer OK = 200;
    public static final Integer ERROR = 500;
    public static final Integer TOKEN_ERROR = 40000;
    public static final Integer VALID_ERROR = 50000;

    static {
        Message.put(OK, "OK");
        Message.put(ERROR, "ERROR");
        Message.put(TOKEN_ERROR, "TOKEN_ERROR");
        Message.put(VALID_ERROR, "VALID_ERROR");
    }
}
