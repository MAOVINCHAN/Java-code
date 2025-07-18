package com.it.p1_DateAndCalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {
        // Calendar和Date比，主要多了一个可以做简单的日期和时间运算的功能。

        // 获取当前时间:
        Calendar c = Calendar.getInstance(); // 先获取calendar实例，默认获取当前时间

        // 获取指定时间：
        c.clear();// 清除所有:
        c.set(Calendar.YEAR, 2019);// 设置2019年:
        c.set(Calendar.MONTH, 8);// 设置9月:注意8表示9月:
        c.set(Calendar.DATE, 2);// 设置2日:
        c.set(Calendar.HOUR_OF_DAY, 21);// 设置时间:
        c.set(Calendar.MINUTE, 22);
        c.set(Calendar.SECOND, 23);

        int y = c.get(Calendar.YEAR); // 年
        int m = 1 + c.get(Calendar.MONTH); // 月
        int d = c.get(Calendar.DAY_OF_MONTH); // 日
        int hh = c.get(Calendar.HOUR_OF_DAY); // 时
        int mm = c.get(Calendar.MINUTE); // 分
        int ss = c.get(Calendar.SECOND); // 秒
        int ms = c.get(Calendar.MILLISECOND); // 毫秒
        int w = c.get(Calendar.DAY_OF_WEEK); // 星期
        System.out.println(y + "-" + m + "-" + d + " " + w + " " + hh + ":" + mm + ":" + ss + "." + ms);

        // 获取Date对象
        Date time = c.getTime();

        // 格式或转为Date对象后的Calendar
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH/mm/ss");
        System.out.println(sdf.format(time));
    }
}
