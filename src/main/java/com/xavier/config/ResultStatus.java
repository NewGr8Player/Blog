package com.xavier.config;

/**
 * <p>自定义请求状态码</p>
 *
 * @author xavier
 * @date 2015/7/15.
 */
public enum ResultStatus {
    SUCCESS(100, "成功！"),
    USERNAME_OR_PASSWORD_ERROR(-1001,"用户名或密码错误！");

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
