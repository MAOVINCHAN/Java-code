package com.qf.learn;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * 依赖： druid
 * 配置文件properties需放在本包内
 */
public class T3_UseDruid {
    public static void main(String[] args) throws Exception {
        InputStream is = T3_UseDruid.class.getResourceAsStream("database.properties");
        Properties properties = new Properties();
        properties.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);
        Connection con = ds.getConnection();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("select * from user_sheet");
        while (res.next()) {
            int id = res.getInt("id");
            String username = res.getString("username");
            System.out.println("id=" + id + ",username=" + username);
        }
        res.close();
        st.close();
        con.close();
    }
}
