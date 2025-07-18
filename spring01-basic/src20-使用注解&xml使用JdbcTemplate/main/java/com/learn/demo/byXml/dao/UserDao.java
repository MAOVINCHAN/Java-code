package com.learn.demo.byXml.dao;

import com.learn.demo.byJava.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


public class UserDao {
    public JdbcTemplate jdbcTemplate;

    public UserDao() {
    }

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 新增 / 删除 / 修改同下
    public int addUser() {
        return jdbcTemplate.update(
            "insert into user(username, nickname, password, enabled, role) values (?,?,?,?,?)",
            "Jerry",
            "杰瑞",
            "123456",
            1,
            3
        );
    }

    // 查询单个用户
    public User getUserById(int id) {
        return jdbcTemplate.queryForObject("select * from user where id=?", new BeanPropertyRowMapper<>(User.class), id);
    }
    // 查询list集合
    public List<User> getUsers() {
        return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
    }
    // 查询总记录数
    public Integer getUserCounts() {
        return jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
    }
    // 查询当前时间
    public String getTime() {
        return jdbcTemplate.queryForObject("select now()", String.class);
    }
}
