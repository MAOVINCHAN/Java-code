package com.project.stusys.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtils {
    private static DataSource ds = null;
    private static final Properties pro = new Properties();
    /**
     * threadLocal 用法和Map类似
     * 作用：在哪个线程寸的，在哪个线程取
     */
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        InputStream is = DbUtils.class.getResourceAsStream("/db.properties");
        try {
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnection() {
        Connection con = threadLocal.get();
        if(con == null) {
            try {
                Connection connection = getDataSource().getConnection();
                threadLocal.set(connection);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}
