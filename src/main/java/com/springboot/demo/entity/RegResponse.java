package com.springboot.demo.entity;

/**
 *  响应结果封装
 */
public class RegResponse {
    private Integer status =200;
    private String regMsg ;
    private Object data ;

    public RegResponse() {
    }

    public RegResponse(Integer status) {
        this.status = status;
    }

    public RegResponse(Integer status, String regMsg, Object data) {
        this.status = status;
        this.regMsg = regMsg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRegMsg() {
        return regMsg;
    }

    public void setRegMsg(String regMsg) {
        this.regMsg = regMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RegResponse{" +
                "status=" + status +
                ", regMsg='" + regMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
