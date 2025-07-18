package com.qf.learn;

import com.qf.entity.UserSheet;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.*;

public class T5_UseDBUtils_Review {
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        pro.load(new FileInputStream("dbcpconfig.properties"));
        DataSource ds = BasicDataSourceFactory.createDataSource(pro);


        QueryRunner qr = new QueryRunner(ds);
        // 插入一条数据
        String sql1 = "insert into user_sheet(username, password, age, phone_number, address, score) values(?,?,?,?,?,?)";
        UserSheet user = new UserSheet();
        user.setUsername("张三丰");
        user.setPassword("_11_22");
        user.setAge(231);
        user.setPhone_number("18890740000");
        user.setAddress("jiangsu");
        user.setScore(88.5);
        Object[] params = {
                user.getUsername(),
                user.getPassword(),
                user.getAge(),
                user.getPhone_number(),
                user.getAddress(),
                user.getScore()
        };
        int num1 = qr.update(sql1, params);
        System.out.println("num1: " + num1);


        // 更新一条数据
        String sql2 = "update user_sheet set score=? where username = ?";
        Object[] params2 = {100, user.getUsername()};
        int num2 = qr.update(sql2, params2);
        System.out.println("num2: " + num2);


        // 查询单条数据
        String sql3 = "select * from user_sheet where id = ?";
        UserSheet target = qr.query(sql3, new BeanHandler<>(UserSheet.class), 2);
        System.out.println("user: " + target);


        // 查询多条数据
        String sql4 = "select * from user_sheet";
        List<UserSheet> targets = qr.query(sql4, new BeanListHandler<>(UserSheet.class));
        targets.forEach((UserSheet item) -> {
            System.out.println(item);
        });


        // 获取总记录条数
        String sql5 = "select count(1) from user_sheet";
        Object count = qr.query(sql5, new ScalarHandler<>());
        System.out.println("count: " + count);


        // 获取单条记录封装到数组中
        Object[] userInArr = qr.query(sql3, new ArrayHandler(), 2);
        System.out.println(Arrays.toString(userInArr));


        // 获取多条记录封装到数组中
        List<Object[]> usersInArr = qr.query(sql4, new ArrayListHandler());
        usersInArr.forEach((users) -> {
            System.out.println(Arrays.toString(users));
        });


        // 获取单条数据封装到map中
        Map<String, Object> userInMap = qr.query(sql3, new MapHandler(), 1);
        Set<Map.Entry<String, Object>> entries = userInMap.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        // 获取多条数据封装到map中
        List<Map<String, Object>> usersInMap = qr.query(sql4, new MapListHandler());
        usersInMap.forEach((Map<String, Object> map) -> {
            Set<Map.Entry<String, Object>> entries1 = map.entrySet();
            entries1.forEach((en) -> {
                System.out.println(en.getKey() + ": " + en.getValue());
            });
        });
    }
}
