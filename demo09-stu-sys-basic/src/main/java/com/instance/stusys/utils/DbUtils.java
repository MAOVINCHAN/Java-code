package com.instance.stusys.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.Properties;

public class DbUtils {
    private static Properties pro = new Properties();

    private static DataSource ds = null;

    static {
        try {
            FileInputStream is = new FileInputStream("C:\\Users\\admin\\Desktop\\project-J\\stu-sys\\db.properties");
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDateSource() {
        return ds;
    }
}
