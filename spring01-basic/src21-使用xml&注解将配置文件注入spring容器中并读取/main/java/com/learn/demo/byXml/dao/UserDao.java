package com.learn.demo.byXml.dao;

import com.learn.demo.byJava.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
    // 新增返回自增的id
    public int addUserReturnId() {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        int num = jdbcTemplate.update((con -> {
            PreparedStatement ps = con.prepareStatement(
                    "insert into user(username,nickname,password, enabled, role)values (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setObject(1, "lisi");
            ps.setObject(2, "李四");
            ps.setObject(3, "654321");
            ps.setObject(4, 0);
            ps.setObject(5, 2);
            return ps;
        }), holder);

        if(num != 1) throw new RuntimeException("Failure insert");

        return holder.getKey().intValue();
    }
}
