package com.keyhuy.paging.common;

/**
 * 封装响应数据
 *
 * @author Key
 * @date 2021/12/10/21:52
 **/
public class ResultInfo<T> {

    private Integer statusCode;
    private String msg;
    private T data;

    public ResultInfo(Integer statusCode, String msg) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.data = null;
    }

    public ResultInfo(Integer statusCode, String msg, T data) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "statusCode=" + statusCode +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
