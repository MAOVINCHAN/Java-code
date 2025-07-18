package com.project.stusys.dao;

import com.project.stusys.model.User;

import java.sql.SQLException;

public interface UserDao {
    User findUserByUsername(String username) throws SQLException;
}
