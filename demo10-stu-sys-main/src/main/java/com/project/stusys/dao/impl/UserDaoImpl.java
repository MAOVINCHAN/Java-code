package com.project.stusys.dao.impl;

import com.project.stusys.utils.DbUtils;
import com.project.stusys.dao.UserDao;
import com.project.stusys.model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
    @Override
    public User findUserByUsername(String username) throws SQLException {
        return queryRunner.query("select * from user where username=?", new BeanHandler<>(User.class), username);
    }
}
