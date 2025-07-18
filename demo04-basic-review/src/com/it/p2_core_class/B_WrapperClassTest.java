package com.it.p2_core_class;

import java.util.Scanner;

public class B_WrapperClassTest {
    public static void main(String[] args) {
        // define
        // Integer n0 = new Integer(10); // 不推荐，会有编译警告
        Integer n1 = 10; // auto boxing
        Integer n2 = Integer.valueOf(10);
        Integer n3 = Integer.valueOf("10");
        int n4 = n1; // auto unboxing

        // 比较两个Integer不可以使用 ==
        Integer n5 = Integer.valueOf(999999);
        Integer n6 = Integer.valueOf(999999);
        System.out.println(n5 == n6); // false;
        System.out.println(n5.equals(n6)); // true
        System.out.println(n5.compareTo(n6)); // 0 相等，-1 小于，1 大于
    }
}
