package com.learn;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(1, "Tom", "123456"));
        users.add(new User(2, "Jerry", "123456"));
        users.add(new User(3, "Blob", "123456"));
        users.add(new User(4, "Hansen", "123456"));
        return users;
    }
}