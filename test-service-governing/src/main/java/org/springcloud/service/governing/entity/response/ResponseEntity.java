package org.springcloud.service.governing.entity.response;

import org.springcloud.service.governing.execption.ConstantResultCode;

/**
* @Description:    java类作用描述
* @Author:         刘涛
* @CreateDate:     2019/4/22 18:17
*/

public class ResponseEntity {

    private Integer errorCode;
    private String errorMsg;
    private Object result;

    public ResponseEntity() {}

    public ResponseEntity(Integer errorCode, Object result) {
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

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
