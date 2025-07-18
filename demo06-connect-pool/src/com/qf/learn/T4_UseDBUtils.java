package com.qf.learn;

import com.qf.entity.UserSheet;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.*;

/**
 * DBCP + dbutils
 */
public class T4_UseDBUtils {
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        pro.load(new FileInputStream("dbcpconfig.properties"));
        DataSource ds = BasicDataSourceFactory.createDataSource(pro);
        QueryRunner qr = new QueryRunner(ds);

        UserSheet user = new UserSheet();
        user.setUsername("Catlin");
        user.setPassword("123456");
        user.setAge(18);
        user.setAddress("shenzhen");
        user.setPhone_number("15122225555");
        user.setScore(99);
        // // 插入的sql, 需要insert / update 只需改变sql即可
        String sql = "insert into user_sheet(username, password, age, phone_number, address, score) values (?,?,?,?,?,?);";
        Object[] params = {user.getUsername(), user.getPassword(), user.getAge(),user.getPhone_number(), user.getAddress(), user.getScore()};
        //int num = qr.update(sql, params);
        //System.out.println("num: " + num);

        // 查询多条数据
        String q_sql = "select * from user_sheet";
        List<UserSheet> users = qr.query(q_sql, new BeanListHandler<UserSheet>(UserSheet.class));
        for (UserSheet _user :
                users) {
            System.out.println(_user);
        }

        // 查询单条数据
        String s_sql = "select * from user_sheet where id = ?";
        UserSheet u = qr.query(s_sql, new BeanHandler<>(UserSheet.class), 3);
        System.out.println(u);

        // 查询单条数据封装到数组中
        String a_sql = "select * from user_sheet where id = ?";
        Object[] s_user = qr.query(a_sql, new ArrayHandler(), 3);
        System.out.println(Arrays.toString(s_user));

        // 查询多条数据封装到数组中
        List<Object[]> users1 = qr.query(q_sql, new ArrayListHandler());
        for (Object[] _users :
                users1) {
            System.out.println(Arrays.toString(_users));
        }

        // 查询单条记录封装到map中
        Map<String, Object> u_map = qr.query(a_sql, new MapHandler(), 3);
        Set<Map.Entry<String, Object>> entries = u_map.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 查询多条记录封装到map中
        List<Map<String, Object>> u_maps = qr.query(q_sql, new MapListHandler());
        for (Map<String, Object> uMap : u_maps) {
            Set<Map.Entry<String, Object>> entries1 = uMap.entrySet();
            for (Map.Entry<String, Object> entry : entries1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println();
        }

        // 查询所有记录
        String c_sql = "select count(1) from user_sheet";
        Long count = (Long) qr.query(c_sql, new ScalarHandler<>());
        int num = Integer.parseInt(count + "");
        System.out.println("count: " + num); // 7
    }
}
