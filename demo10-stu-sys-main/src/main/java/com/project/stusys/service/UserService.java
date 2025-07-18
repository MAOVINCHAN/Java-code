package com.project.stusys.service;

import com.project.stusys.model.LoginInfo;

public interface UserService {
    LoginInfo login(String username, String password);
}
