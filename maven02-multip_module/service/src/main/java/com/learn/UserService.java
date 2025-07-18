package com.learn;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}