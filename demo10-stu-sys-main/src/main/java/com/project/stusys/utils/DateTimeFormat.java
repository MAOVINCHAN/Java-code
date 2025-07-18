package com.project.stusys.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormat {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static String DateTimeToString(LocalDateTime time) {
        return dtf.format(time);
    }

    public static LocalDateTime StringToDateTime(String time) {
        return LocalDateTime.parse(time, dtf);
    }
}

