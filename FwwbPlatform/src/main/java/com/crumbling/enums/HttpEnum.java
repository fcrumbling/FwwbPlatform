package com.crumbling.enums;

public enum HttpEnum {
    // 成功
    SUCCESS(200,"操作成功"),
    EXHIBITOR_NOT_NULL(401,"展商不存在");
    int code;
    String msg;
    HttpEnum(int code, String Msg){
        this.code = code;
        this.msg = Msg;
    }
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
