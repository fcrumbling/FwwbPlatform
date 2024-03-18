package com.crumbling.enums;

public enum HttpEnum {
    // 成功
    SUCCESS(200, "操作成功"),
    EXHIBITOR_NOT_NULL(601, "展商不存在"),
    SYSTEM_ERROR(602, "出现错误"),
    NEED_LOGIN(401, "请登录"),
    NO_OPERATOR_AUTH(403, "无权限操作"),
    USERNAME_EXIST(501,"用户名已存在"),
    PHONENUMBER_EXIST(502,"手机号已存在"),
    EMAIL_EXIST(503, "邮箱已存在"),
    REQUIRE_USERNAME(504, "必需填写用户名"),
    LOGIN_ERROR(505,"用户名或密码错误"),
    CONTENT_NOT_NULL(506,"评论内容不能为空"),
    USERNAME_NOT_NULL(508, "用户名不能为空"),
    NICKNAME_NOT_NULL(509, "昵称不能为空"),
    PASSWORD_NOT_NULL(510, "密码不能为空"),
    EMAIL_NOT_NULL(511, "邮箱不能为空"),
    NICKNAME_EXIST(512, "昵称已经存在"),
    REGISTER_EXIST(513,"已报名"),
    FILE_SIZE_ERROR(514,"图片超过2MB"),
    FILE_TYPE_ERROR(515,"仅支持jpg和png文件"),
    PHONENUMBER_NOT_NULL(521, "手机号码不能为空"),
    ADMINUSER_ERROR(522,"请使用管理员账号");

    int code;
    String msg;

    HttpEnum(int code, String Msg) {
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
