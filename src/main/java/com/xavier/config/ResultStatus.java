package com.xavier.config;

/**
 * <p>自定义请求状态码</p>
 *
 * @author NewGr8Player
 * @date 2017/10/21
 */
public enum ResultStatus {
    SUCCESS(100, "成功！"),
    USER_NOT_FOUND(-1001,"用户不存在"),
    USERNAME_OR_PASSWORD_ERROR(-1002,"用户名或密码错误！");

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String message;

    ResultStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
