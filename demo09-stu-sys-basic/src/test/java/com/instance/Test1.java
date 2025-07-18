package com.instance;

import com.instance.stusys.utils.DateTimeFormat;

import java.time.LocalDateTime;

public class Test1 {
    public static void main(String[] args) {
        String str = DateTimeFormat.DateTimeToString(LocalDateTime.now());
        System.out.println("str = " + str);

        String time = "2025/06/17 16:56:49";
        LocalDateTime localDateTime = DateTimeFormat.StringToDateTime(time);
        System.out.println("localDateTime = " + localDateTime);
    }
}
