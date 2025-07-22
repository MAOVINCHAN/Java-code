package com.learn.demo.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


public class UserDao {
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int add(String uname, Double m) {
        int i = 0;
        try {
            i = jdbcTemplate.update("update user_balance set balance = balance + ? where username = ?", m, uname);
            System.out.println(uname + "增加了：" + m);
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    public int min(String uname,Double m) {
        int i = 0;
        try {
            i = jdbcTemplate.update("update user_balance set balance = balance - ? where username = ?", m, uname);
            System.out.println(uname + "减少了：" + m);
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
        return i;
    }
}
