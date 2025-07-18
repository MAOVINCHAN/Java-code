package com.it.p2_localDataTime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println("now: " + now);
        LocalTime time = LocalTime.now();
        System.out.println("time: " + time);
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("dateTime: " + dateTime);

        // 由于代码执行或多或少需要时间导致的获取的不是同一个时间，解决方式：
        LocalDateTime dt = LocalDateTime.now();
        LocalDate d = dt.toLocalDate();
        LocalTime t = dt.toLocalTime();

        // 设置时区
        ZonedDateTime dtny = dt.atZone(ZoneId.of("America/New_York"));

        // 通过指定的日期/时间创建 LocalDataTime
        LocalDate d1 = LocalDate.of(2024, 9, 30);
        System.out.println("d1: " + d1);
        LocalTime d2 = LocalTime.of(23, 45, 45); // hour最大为 23
        System.out.println("d2: " + d2);

        // parse
        LocalDateTime d3 = LocalDateTime.parse("2024-09-30T12:01:01"); // 注意ISO 8601规定的日期和时间分隔符是T
        System.out.println("d3: " + d3);
        System.out.println(d3.toLocalDate()); // success
        System.out.println(d3.toLocalTime()); // success

        LocalDate d4 = LocalDate.parse("2024-11-11"); // 分隔符必须为 - 而非 /
        System.out.println("d4: " + d4);
        System.out.println(d4.toString());

        LocalTime d5 = LocalTime.parse("10:15:15"); // 分隔符必须为 : 而非 /
        System.out.println("d5: " + d5);
        System.out.println(d5.toString());

        // 格式化LocalDataTime, 方式一: 自定义格式化
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd HH/mm/ss");
        String formatD3 = df.format(d3);
        System.out.println("formatD3: " + formatD3);

        // 格式化LocalDataTime, 方式二：用自定义格式解析字符串为LocalDataTime
        LocalDateTime d6 = LocalDateTime.parse("2024/09/30 12/01/01", df); // 结果为： 2024-09-30T12:01:01
        System.out.println("d6: " + d6);

        // 日期加减，支持链式调用
        // 调用返回新时间，不会改变原始时间的值
        LocalDateTime d61 = d6.plusYears(1);
        LocalDateTime d62 = dt.minusYears(2);
        LocalDateTime d63 = d6.plusMonths(1);
        LocalDateTime d64 = d6.minusMonths(2);
        LocalDateTime d65 = d6.plusDays(1);
        LocalDateTime d66 = d6.minusDays(2);
        // 链式调用
        LocalDateTime d7 = dt.plusYears(1)
                            .minusYears(2)
                            .plusMonths(1)
                            .minusMonths(2)
                            .plusDays(1)
                            .minusDays(2);
        System.out.println("d7: " + d7);

        // 调整单个位置的时间
        // 调用返回新时间，不会改变原始时间的值
        LocalDateTime d71 = d7.withYear(2025);
        LocalDateTime d72 = d7.withMonth(5);
        LocalDateTime d73 = d7.withDayOfMonth(15);
        LocalDateTime d74 = d7.withHour(15);
        LocalDateTime d75 = d7.withMinute(15);
        LocalDateTime d76 = d7.withSecond(15);
        // 链式调用
        LocalDateTime d8 = d7.withYear(2025)
                .withMonth(5)
                .withDayOfMonth(15)
                .withHour(15)
                .withMinute(15)
                .withSecond(15);
        System.out.println("d8: " + d8); // 2025-05-15T15:15:15.775479400

        // 判断之前或之后
        System.out.println(d8.isBefore(d7)); // false
        System.out.println(d8.isAfter(d7)); // true

        // 计算差值
        // 1. LocalDateTime差值
        LocalDateTime start = LocalDateTime.of(2022, 11, 25, 10, 10, 10);
        LocalDateTime end = LocalDateTime.of(2019, 4, 15, 15, 30, 30);
        Duration dis1 = Duration.between(start, end);
        System.out.println("dis1: " + dis1);  // PT-31674H-39M-40S
        // 2. LocalDate差值
        LocalDate ds = LocalDate.of(2023, 9, 1);
        LocalDate de = LocalDate.of(2024, 1, 15);
        Period dis2 = Period.between(ds, de);
        System.out.println("dis2: " + dis2); // P4M14D

        // Duration
        System.out.println(Duration.ofHours(10)); // PT10H
        System.out.println(Duration.ofMinutes(15)); // PT15M
        // String to Duration
        Duration parse1 = Duration.parse(dis1.toString());
        System.out.println("parse1: " + parse1);
    }
}
