package org.springcloud.eureka.server.execption;

/**
* @Description:    java类作用描述
* @Author:         刘涛
* @CreateDate:     2019/4/22 18:17
*/

public class BusinessException extends Exception {

    Integer code;
    public BusinessException() {
        super();
    }
    public BusinessException(Integer code) {
        super(ConstantResultCode.Message.get(code));
        this.code = code;
    }
    public BusinessException(Integer code, String extMessage) {
        super(extMessage);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "code=" + code +
                '}';
    }
}
