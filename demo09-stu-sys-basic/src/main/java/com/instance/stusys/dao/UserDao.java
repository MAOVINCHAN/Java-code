package com.instance.stusys.dao;

import com.instance.stusys.model.User;
import com.instance.stusys.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    QueryRunner qr = new QueryRunner(DbUtils.getDateSource());

    public Long getTotal() throws SQLException {
        return qr.query("select count(*) from users", new ScalarHandler<>());
    }

    public int addUser(User user) throws SQLException {
        Object[] params = {
            user.getUsername(),
            user.getPassword(),
            user.getReal_name(),
            user.getEmail(),
            user.getPhone(),
        };

        return qr.update(
            "insert into users(username, password,real_name,email, phone, avatar_id, account_status, last_login, created_at, updated_at) values (?,?,?,?,?,?,?,?,?,?)",
            params
        );
    }

    public User findUserById(int id) throws SQLException {
        return qr.query("select * from users where user_id = ?", new BeanHandler<>(User.class), id);
    }

    public User findUserByUsername(String username) throws SQLException {
        return qr.query("select * from users where username = ?", new BeanHandler<>(User.class), username);
    }

    public User login(String username, String password) throws SQLException {
        Object[] params = {username, password};
        return qr.query("select * from users where username = ? and password = ?", new BeanHandler<>(User.class), params);
    }

    public List<User> getUsers() throws SQLException {
        return qr.query("select * from users", new BeanListHandler<>(User.class));
    }

    public List<User> getUsersByPage(Integer page, Integer limit) throws SQLException {
        return qr.query("select * from users limit ?,?", new BeanListHandler<>(User.class), (page - 1) * limit, limit);
    }

    public int deleteUserById(String id) throws SQLException {
        return qr.update("delete from users where user_id = ?", id);
    }

    public User getUserByid(String id) throws SQLException {
        return qr.query("select * from users where user_id = ?", new BeanHandler<>(User.class), id);
    }

    public int updateUser(User user) throws SQLException {
        Object[] params = {
                user.getReal_name(),
                user.getPassword(),
                user.getEmail(),
                user.getPhone(),
                user.getUser_id()
        };
        return qr.update("update users set real_name = ? ,password = ?, email = ?, phone = ? where user_id = ?", params);
    }
}
