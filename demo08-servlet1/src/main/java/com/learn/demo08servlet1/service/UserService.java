package com.learn.demo08servlet1.service;

import com.learn.demo08servlet1.model.User;

import java.util.List;

// 事务在service中开启
public interface UserService {
    User getUserById(int id);
    List<User> getUsers();
    boolean login(String username, String password);
    User getUserByUsername(String username);
    int addUser(User user);

    int deleteUserById(int id);
}
