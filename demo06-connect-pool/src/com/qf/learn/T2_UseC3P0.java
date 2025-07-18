package com.qf.learn;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class T2_UseC3P0 {
    public static void main(String[] args) throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        System.out.println("cpds: " + cpds);
        Connection connection = cpds.getConnection();
        System.out.println("connection: " + connection);
        // PreparedStatement ps = connection.prepareStatement("select * from user_sheet");
        // ResultSet res = ps.executeQuery();
        Statement statement = connection.createStatement();
        System.out.println("statement: " + statement);
        ResultSet res = statement.executeQuery("select * from user_sheet");
        System.out.println("res: " + res);
        while (res.next()) {
            System.out.println("res.next()： " + res.next());
            int id = res.getInt("id");
            String username = res.getString("username");
            System.out.println("id=" + id + ",username=" + username);
        }
        System.out.println("end");
        res.close();
        statement.close();
        connection.close();
    }
}
