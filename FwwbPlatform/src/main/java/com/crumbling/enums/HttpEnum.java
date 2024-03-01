package com.crumbling.enums;

public enum HttpEnum {
    // 成功
    SUCCESS(200,"操作成功"),
    EXHIBITOR_NOT_NULL(601,"展商不存在"),
    NEED_LOGIN(401,"请登录"),
    NO_OPERATOR_AUTH(403,"无权限操作" ),
    LOGIN_ERROR(503, "用户名或密码错误"),
    SYSTEM_ERROR(504,"出现错误"),;
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
