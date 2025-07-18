package com.learn.demo;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public User getUserByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        user.setAddress("beijing");
        return user;
    }
}
