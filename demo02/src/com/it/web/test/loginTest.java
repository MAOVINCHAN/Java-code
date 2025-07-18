package com.it.web.test;

import com.it.web.dao.UserDao;
import com.it.web.domain.User;
import org.junit.Test;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.Arrays;

public class loginTest {
    @Test
    public void login() throws SQLException {
        UserDao userDao = new UserDao();

        User user = new User();

        user.setUsername("zhangsan");
        user.setPassword("123456");

        User userFound = userDao.login(user);

        System.out.println(userFound != null ? userFound.getUsername() : null);
    }

    @Test
    public void Test() {
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println("使用==，结果为: " + (s1 == s2)); // false
        System.out.println("使用equals，结果为: " + s1.equals(s2)); // true
        System.out.println("使用忽略大小写equals：" + (s1.equalsIgnoreCase(s2))); // true
        System.out.println("--------------");
        System.out.println("判断是否包含：" + s1.contains("ll")); // true
        System.out.println("从头开始获取索引：" + s1.indexOf("l")); // 2
        System.out.println("从末尾开始获取索引：" + s1.lastIndexOf("l")); // 3
        System.out.println("判断是否以该值开头：" + s1.startsWith("he")); // true
        System.out.println("判断是否已该值结尾：" + s1.endsWith("lo")); // true
        System.out.println("提取子串：从开头到结尾（包含开头）" + s1.substring(2)); // llo
        System.out.println("提取子串：从开头到索引（包头不包尾）" + s1.substring(2, 4)); // ll
        System.out.println("判断是否为空格：" + (" ".isBlank())); // true
        System.out.println("判断是否为空：" + ("").isEmpty()); // true
        System.out.println("判断是否为空：" + (" ").isEmpty()); // false
        System.out.println("替换子串：" + s1.replace("o", "")); // hell
        System.out.println("替换所有：" + s1.replaceAll("l", "w")); // "hewwo";
        System.out.println("分割字符串为数组：" + Arrays.toString("A,B,C,D,E".split(","))); // [A, B, C, D, E]
        String[] aeiou = {"a", "e", "i", "o", "u"};
        System.out.println("转换数组为字符串：" + String.join("***",aeiou)); // a***e***i***o***u
    }

    @Test
    public void XML() {

    }
}
