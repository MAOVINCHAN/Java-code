package com.it.web.dao;

import com.it.web.domain.User;
import com.it.web.utils.JDBCUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// 操作数据库user表
public class UserDao {
    public User login(User user) throws SQLException {
        String sql = "select * from goals_user where uname = '"+ user.getUsername() +"' and upassword = '" + user.getPassword() + "';";
        System.out.println("sql: " + sql);

        JDBCUtils jdbcUtils = new JDBCUtils();
        Statement statement = jdbcUtils.getStatement();

        try {
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<User> users = new ArrayList<>();
            while (resultSet.next()) {
                String uname = resultSet.getString("uname");
                String u_password = resultSet.getString("upassword");
                User user_found = new User(uname, u_password);
                users.add(user_found);
            }
            return users.size() > 0 ? users.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
