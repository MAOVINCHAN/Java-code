package com.it.p2_core_class;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class A_StringTest {
    public static void main(String[] args) {
        String s1 = "hello,world";
        String s2 = new String("hello,world");
        System.out.println("s1 == s2:" + (s1 == s2)); // false
        System.out.println("s1.equals(s2):" + (s1.equals(s2))); // true

        String[] s12arr = s1.split(",");
        System.out.println(Arrays.toString(s12arr));

        int s1_len = s1.length();
        System.out.println("计算字符串长度：" + s1_len);

        byte[] bytes = s1.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));

        String news1 = s1.replaceAll("hello", "java hello");
        System.out.println("news1 is:" + news1);
        System.out.println("olds1 is:" + s1);

        String substring = s1.substring(0, 5); //[0, 5), 截取，包头不包尾
        System.out.println("sbustring is:" + substring);

        char c = s1.charAt(0);
        System.out.println("c is: " + c); // h

        String s11 = "!";
        s1 += s11;
        System.out.println("s1 is: " + s1);

        String[] arr = {"name1", "name2", "name3"};
        String res = String.join(",", arr);
        System.out.println("res is: " + res);
    }
}
