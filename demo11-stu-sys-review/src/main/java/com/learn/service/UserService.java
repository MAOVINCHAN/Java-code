package com.learn.service;

import com.learn.Utils.PwdUtils;
import com.learn.dao.UserDao;
import com.learn.model.RespBean;
import com.learn.model.User;

import java.sql.SQLException;

public class UserService {
    private UserDao userDao = new UserDao();
    public RespBean login(String username, String password) {
        try {
            User user = userDao.getUserByUsername(username);
            if(user == null) return RespBean.error("用户不存在");

            if(user.getEnabled() == 0) {
                return RespBean.error("用户被禁用");
            }

            boolean verify = PwdUtils.checkPassword(password, user.getPassword());
            if(!verify) {
                return RespBean.error("用户名或密码错误");
            }

            return RespBean.success("success", user);
        } catch (SQLException e) {
            return RespBean.error(e.getMessage());
        }
    }
}
