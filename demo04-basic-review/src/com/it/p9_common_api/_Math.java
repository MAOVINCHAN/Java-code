package com.it.p9_common_api;

public class _Math {
    public static void main(String[] args) {
        // 获取自然对数的基数
        System.out.println(Math.E); // 2.718281828459045
        // 获取π
        System.out.println(Math.PI); // 3.141592653589793
        // 获取绝对值
        System.out.println(Math.abs(-5)); // 5
        // 向下取整，返回double
        System.out.println(Math.floor(1.2)); // 1.0
        // 向上取整
        System.out.println(Math.ceil(1.2)); // 2.0
        // 获取大于等于0小于1.0的随机数
        System.out.println(Math.random());
        // 获取0-20之间的随机数
        System.out.println(Math.random() * 20);
        // max
        System.out.println(Math.max(15, 50)); // 50
        // min
        System.out.println(Math.min(15, 20)); // 15
    }
}
