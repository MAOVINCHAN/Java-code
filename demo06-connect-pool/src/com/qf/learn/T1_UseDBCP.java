package com.qf.learn;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class T1_UseDBCP {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("dbcpconfig.properties"));
        DataSource ds = BasicDataSourceFactory.createDataSource(properties);
        Connection con = ds.getConnection();

        PreparedStatement ps = con.prepareStatement("select * from user_sheet");
        ResultSet res = ps.executeQuery();
        while (res.next()) {
            int id = res.getInt("id");
            String username = res.getString("username");
            System.out.println("id=" + id + ",username=" + username);
        }
        res.close();
        ps.close();
        con.close();
    }
}
