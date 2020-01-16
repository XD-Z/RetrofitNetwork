package com.dogal.retrofitnetwork.bean;

import java.io.Serializable;

/**
 * author: Dogal
 * data: 2020/01/01
 */

public class FileBean implements Serializable {

    /**
     * retcode : 2000
     * msg : 发送成功!
     * data : 94
     */
    private int status;
    private String msg;
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}