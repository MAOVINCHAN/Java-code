package com.it.web.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
    private final String url = "jdbc:mysql://localhost:3306";
    public Connection con;

    public Statement statement;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public JDBCUtils() throws SQLException {
        con = DriverManager.getConnection(url, "root", "root");

        System.out.println("Database connected successfully!");

        statement = con.createStatement();

        statement.execute("use goals");
    }

    public Connection getCon() {
        return con;
    }

    public Statement getStatement() throws SQLException {
        return statement;
    }
}
