package com.wz.domain;

import java.util.Date;

/**
 * Created by zhenwang on 2018/2/28.
 */
public class LoginLog {

    private int loginLog;
    private int userId;
    private String ip;
    private Date loginDate;

    public int getLoginLog() {
        return loginLog;
    }

    public void setLoginLog(int loginLog) {
        this.loginLog = loginLog;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
