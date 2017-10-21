package com.xavier.authorization.model;

/**
 * <p>Token的Model类</p>
 *
 * @author Newgr8Player
 * @date 2017/10/15
 */
public class TokenModel {

    /* 用户id */
    private String userId;
    /* token */
    private String token;

    public TokenModel(String userId,String token) {
        this.userId = userId;
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String toLocalString() {
        return userId + "_" +token;
    }
}
