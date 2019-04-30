package org.springcloud.service.governing.execption;

/**
* @Description:    java类作用描述
* @Author:         刘涛
* @CreateDate:     2019/4/22 18:17
*/

import java.util.HashMap;
import java.util.Map;

public class ConstantResultCode {
    public static final Map<Integer, String> Message = new HashMap<>();
    public  static final Integer OK = 200;
    public static final Integer ERROR = 500;
    public static final Integer TOKEN_ERROR = 40000;

    static {
        Message.put(OK, "OK");
        Message.put(ERROR, "ERROR");
        Message.put(TOKEN_ERROR, "TOKEN_ERROR");
    }
}
