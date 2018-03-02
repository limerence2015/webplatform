package com.wz.dao;

import com.wz.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by zhenwang on 2018/3/2.
 */
@Repository
public class LoginLogDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 保存登录日志
     */
    public void insertLoginLog(LoginLog loginLog) {
        String sqlStr = "insert into t_login_log(user_id,ip,login_datetime) values(?,?,?)";
        Object[] args = new Object[]{loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate()};
        jdbcTemplate.update(sqlStr,args);
    }
}
