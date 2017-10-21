package com.xavier.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xavier.config.ResultStatus;

import java.util.Date;

/**
 * <p>响应结果</p>
 *
 * @author NewGr8Player
 * @since 2017/10/14
 */
public class ResultModel {

    private int code; /* 返回码 */

    private String message; /* 返回结果描述 */

    private Date requestDate; /* 响应时间 */

    private Object content; /* 返回内容 */

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getRequestDate() {
        return requestDate;
    }

    public Object getContent() {
        return content;
    }

    public ResultModel(int code, String message) {
        this.code = code;
        this.message = message;
        this.content = "";
        this.requestDate = new Date();
    }

    public ResultModel(int code, String message, Object content) {
        this.code = code;
        this.message = message;
        this.content = content;
        this.requestDate = new Date();
    }

    public ResultModel(ResultStatus status) {
        this.code = status.getCode();
        this.message = status.getMessage();
        this.content = "";
        this.requestDate = new Date();
    }

    public ResultModel(ResultStatus status, Object content) {
        this.code = status.getCode();
        this.message = status.getMessage();
        this.content = content;
        this.requestDate = new Date();
    }

    public static ResultModel ok(Object content) {
        return new ResultModel(ResultStatus.SUCCESS, content);
    }

    public static ResultModel ok() {
        return new ResultModel(ResultStatus.SUCCESS);
    }

    public static ResultModel error(ResultStatus error) {
        return new ResultModel(error);
    }

    public static ResultModel error(ResultStatus status, Object content) {
        return new ResultModel(status, content);
    }
}
