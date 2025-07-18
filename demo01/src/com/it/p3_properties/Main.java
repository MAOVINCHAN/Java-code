package com.it.p3_properties;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        // 读取
        Properties properties = new Properties();
        properties.load(Main.class.getResourceAsStream("./test.properties"));

        String a = properties.getProperty("a");

        Enumeration<Object> keys = properties.keys();
        while (keys.hasMoreElements()) {
            Object o = keys.nextElement();
            String property = properties.getProperty((String) o);
            System.out.println(o + ": " + property);
        }

        // 写入
        Properties p2 = new Properties();
        p2.setProperty("p1", "3.1415926");
        p2.setProperty("p2", "value");
        p2.setProperty("p3", "bcdedit");
        p2.store(
                new FileOutputStream(
                "C:\\Users\\admin\\Desktop\\project-Java\\demo01\\src\\com\\it\\p3_properties\\test1.properties"
                ),
                "这是写入的properties注释"
        );
    }
}
