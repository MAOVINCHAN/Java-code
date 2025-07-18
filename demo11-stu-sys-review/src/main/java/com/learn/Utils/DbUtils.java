package com.learn.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtils {
    private static Properties properties = new Properties();
    private static DataSource dataSource = null;

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        InputStream is = DbUtils.class.getResourceAsStream("/dbConfig.properties");
        try {
            properties.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() {
        Connection connection = threadLocal.get();
        if(connection == null) {
            try {
                Connection con = getDataSource().getConnection();
                threadLocal.set(con);
                return con;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
