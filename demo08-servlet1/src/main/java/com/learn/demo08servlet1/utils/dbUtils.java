package com.learn.demo08servlet1.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.Properties;

public class dbUtils {
    private static Properties pro = new Properties();
    private static DataSource ds = null;

    static {
        try {
            FileInputStream is = new FileInputStream("C:/Users/admin/Desktop/project-J/demo08-servlet1/db.properties");
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }
}
