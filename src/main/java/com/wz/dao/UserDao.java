package com.wz.dao;

import com.wz.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.security.auth.callback.CallbackHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by zhenwang on 2018/2/28.
 */
@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 根据用户名和密码获取匹配的用户数
     */
    public int getMatchCount(String username, String password) {
        String sqlStr = "select count(*) from t_user where user_name=? and password=?";
        Integer result = jdbcTemplate.queryForObject(sqlStr, new Object[]{username, password}, Integer.class);
        return result;
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    public User findUserByUserName(String username) {
        String sqlStr = "select user_id, user_name, credits from t_user where user_name = ?";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{username}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setCredits(rs.getInt("credits"));
            }
        });
        return user;
    }

    /**更新用户表中用户登录的信息*/
    public void updateLoginInfo(int credits, String ip, Date lastVisit) {
        String sqlStr = "update t_user set last_visit=?, last_ip=?, credits=?";
        jdbcTemplate.update(sqlStr, new Object[]{lastVisit, ip, credits});
    }


}
