package com.it.p1_DateAndCalendar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        // 已废弃且不再推荐使用的方式
        Date date = new Date();

        System.out.println(date.getYear() + 1900); // 年
        System.out.println(date.getMonth() + 1); // 月
        System.out.println(date.getDate()); // 日
        System.out.println(date.getHours()); // 时
        System.out.println(date.getMinutes()); // 分
        System.out.println(date.getSeconds()); // 秒
        System.out.println(date.getDay()); // 星期

        System.out.println(date.toString()); // Mon Sep 30 10:55:20 CST 2024
        System.out.println(date.toGMTString()); // 30 Sep 2024 02:55:20 GMT
        System.out.println(date.toLocaleString()); // 2024年9月30日 上午10:55:20

        // 格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 2024-09-30 10:55:20
        System.out.println(sdf.format(date));
    }
}
