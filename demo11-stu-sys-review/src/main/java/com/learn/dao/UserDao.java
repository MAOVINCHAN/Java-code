package com.learn.dao;

import com.learn.Utils.DbUtils;
import com.learn.model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    private QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());

    public User getUserByUsername(String username) throws SQLException {
        return queryRunner.query("select * from user where username=?", new BeanHandler<>(User.class), username);
    }
}
