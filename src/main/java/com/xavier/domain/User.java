package com.xavier.domain;

import io.swagger.annotations.ApiParam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>User Bean</p>
 */
@Entity
@Table(name = "sys_user")
public class User {

    @Id
    @Column(name = "id")
    @ApiParam(hidden = true)
    private String id;

    @Column(name = "username")
    @ApiParam(name = "username", value = "用户名", required = true)
    private String username;

    @Column(name = "password")
    @ApiParam(name = "password", value = "密码", required = true)
    private String password;

    @Column(name = "nickname")
    @ApiParam(hidden = true)
    private String nickname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
