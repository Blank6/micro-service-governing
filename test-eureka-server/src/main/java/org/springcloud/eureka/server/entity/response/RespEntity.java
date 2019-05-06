package org.springcloud.eureka.server.entity.response;


import org.springcloud.eureka.server.execption.ConstantResultCode;

/**
* @Description:    java类作用描述
* @Author:         刘涛
* @CreateDate:     2019/4/22 18:17
*/

public class RespEntity {

    private Integer errorCode;
    private String errorMsg;
    private Object result;

    @Override
    public String toString() {
        return "RespEntity{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", result=" + result +
                '}';
    }

    public RespEntity() {}

    public RespEntity(Integer errorCode, Object result) {
        this.errorCode = errorCode;
        this.errorMsg = ConstantResultCode.Message.get(errorCode);
        this.result = result;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
