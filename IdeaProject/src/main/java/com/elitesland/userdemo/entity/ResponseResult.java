package com.elitesland.userdemo.entity;


public class ResponseResult<T> {

    public static final int STATE_OK = 1;
    public static final int STATE_ERR = 0;
    private Integer state;
    private String message;
    private T data;

    public ResponseResult() {
        super();
    }

    public ResponseResult(Integer state) {
        super();
        this.state = state;
    }

    public ResponseResult(Integer state, String message) {
        super();
        this.state = state;
        this.message = message;
    }

    public ResponseResult(Exception e) {
        super();
        setState(STATE_ERR);
        setMessage(e.getMessage());
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
