package com.example.demo.exception;

/**
 * Created by admin on 2017/5/18.
 */
public class ModulViewException extends  MyException {

    private String msg ;
    private Integer code;

    public ModulViewException() {
    }

    public  ModulViewException(String msg, Integer code){
        this.msg=msg;
        this.code=code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
