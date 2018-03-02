package com.wz.service;

import com.wz.dao.LoginLogDao;
import com.wz.dao.UserDao;
import com.wz.domain.LoginLog;
import com.wz.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhenwang on 2018/3/2.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String username, String password) {
        return userDao.getMatchCount(username, password) > 0;
    }

    public User findUserByName(String username) {
        return userDao.findUserByUserName(username);
    }

    @Transactional
    public void loginSuccess(User user) {
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        loginLog.setUserId(user.getUserId());
        userDao.updateLoginInfo(user.getCredits(), user.getLastIp(), user.getLastVisit());
        loginLogDao.insertLoginLog(loginLog);
    }
}
