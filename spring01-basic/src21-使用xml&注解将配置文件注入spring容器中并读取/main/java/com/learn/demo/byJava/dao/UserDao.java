package com.learn.demo.byJava.dao;

import com.learn.demo.byJava.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

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

    // 新增返回自增的id
    public int addUserReturnId() {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        int num = jdbcTemplate.update((con -> {
            // 创建PreparedStatement时，必须指定RETURN_GENERATED_KEYS:
            PreparedStatement ps = con.prepareStatement(
            "insert into user(username, nickname, password, enabled, role) values (?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS
            );
            ps.setObject(1, "Tom");
            ps.setObject(2, "汤姆");
            ps.setObject(3, "123456");
            ps.setObject(4, 1);
            ps.setObject(5, 3);
            return ps;
        }), holder);

        if(num != 1) throw new RuntimeException("Failure insert");

        // holder.getKey().intValue(); // 获取新增后的自增id
        return holder.getKey().intValue();
    }
}
