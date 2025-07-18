package com.instance.stusys.service;

import com.instance.stusys.dao.UserDao;
import com.instance.stusys.model.Pagination;
import com.instance.stusys.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();
    public int addUser(User user) {
        int num = 0;
        try {
            User exitUser = userDao.findUserByUsername(user.getUsername());
            if(exitUser != null) {
                return -1;
            }
            num = userDao.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    public User login(String username, String password) {
        User user = null;
        try {
            user = userDao.login(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User findUserByUsername(String username) {
        User user = null;
        try {
            user = userDao.findUserByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public List<User> getUsers() {
        try {
            return userDao.getUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Pagination getPagination(Integer page, Integer limit) {
        Pagination pagination = new Pagination();
        try {
            Integer total = userDao.getTotal().intValue();
            pagination.setTotal(total);
            pagination.setCurrent(page);
            pagination.setFirst(page == 1);
            int totalPage = total % limit == 0 ? total / limit : total / limit + 1;
            pagination.setPage_count(totalPage);
            pagination.setLast(page == totalPage);
            List<User> users = userDao.getUsersByPage(page, limit);
            pagination.setData(users);
            pagination.setLimit(limit);
            String url = "http://localhost:8081/stu-sys/users?";
            pagination.setFirst_url(url + "page=" + 1 + "&limit=" + limit);
            pagination.setLast_url(url + "page=" + totalPage + "&limit=" + limit);
            if(!pagination.isFirst()) {
                pagination.setPre_url(url + "page=" + (page - 1) + "&limit=" + limit);
            }
            if(!pagination.isLast()) {
                pagination.setNext_url(url + "page=" + (page + 1) + "&limit=" + limit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pagination;
    }

    public int deleteUserById(String id) {
        try {
            return userDao.deleteUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public User getUserById(String id) {
        try {
            return userDao.getUserByid(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateUser(User user) {
        int num = 0;
        try {
            num = userDao.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num != 0;
    }
}
