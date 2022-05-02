package com.hongguo.dubbo.domain;

import java.io.Serializable;

/**
 * @author hongguo_cheng
 * @date 2022/4/5
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -428222486606687770L;

    private T data;

    private boolean success;

    private String msg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
