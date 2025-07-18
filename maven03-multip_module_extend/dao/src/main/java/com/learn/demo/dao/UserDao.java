package com.learn.demo.dao;

import com.learn.demo.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "Tom", "123456"));
        users.add(new User(2, "Jerry", "123456"));
        users.add(new User(3, "Blob", "123456"));
        users.add(new User(4, "Hansen", "123456"));
        users.add(new User(5, "Juli", "123456"));
        return users;
    }
}
