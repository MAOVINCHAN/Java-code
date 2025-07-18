package com.project.stusys.service.impl;

import com.project.stusys.dao.UserDao;
import com.project.stusys.dao.impl.UserDaoImpl;
import com.project.stusys.model.LoginInfo;
import com.project.stusys.model.User;
import com.project.stusys.service.UserService;
import com.project.stusys.utils.PwdUtils;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public LoginInfo login(String username, String password) {
        try {
            User user = userDao.findUserByUsername(username);
            if(user == null) {
                return new LoginInfo(0, "用户名或密码错误",  null);
            }

            String hashed = PwdUtils.hashPassword(password);
            Boolean permission = PwdUtils.checkPassword(user.getPassword(), hashed);

            if(!permission) {
                return new LoginInfo(0, "用户名或密码错误",  null);
            }

            if(user.getEnabled() != 1) {
                return new LoginInfo(-1, "登录失败，账户已被禁用",  null);
            }

            return new LoginInfo(1, "登录成功",  user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new LoginInfo(0, "用户名或密码错误",  null);
    }
}
