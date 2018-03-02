package com.wz.web;

/**
 * Created by zhenwang on 2018/3/2.
 */
public class LoginCommand {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
