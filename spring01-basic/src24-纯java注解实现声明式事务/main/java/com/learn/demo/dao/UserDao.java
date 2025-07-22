package com.learn.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

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
