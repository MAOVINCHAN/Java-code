package com.it.p0_test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalTime;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IOTest {
    public static void main(String[] args) throws Exception {
        // String path = "C:/Users/admin/Desktop/test.txt";
        // FileWriter fw = new FileWriter(path);
        // fw.write("first line\n");
        // fw.write("second line\n");
        // fw.write("third line\n");
        // fw.write("fourth line\n");
        // System.out.println("success!");
        // fw.close();
        //
        // FileReader fr = new FileReader(path);
        // BufferedReader br = new BufferedReader(fr);
        // String s = null;
        // while ((s = br.readLine()) != null) {
        //     System.out.println("s is: " + s);
        // }


        // String reg = "\\d+\\+";
        // String str = "11+";
        // System.out.println(str.matches(reg)); // true

        // Pattern pattern = Pattern.compile("\\d+\\+");
        // Matcher matcher = pattern.matcher("11+");
        // if(matcher.find()) {
        //     System.out.println("匹配成功：" + matcher.group());
        // }else {
        //     System.out.println("匹配失败");
        // }

        // new TimerThread(new Function() {
        //     @Override
        //     public Object apply(Object o) {
        //
        //         return null;
        //     }
        // }).start();

        // DecThread dec = new DecThread();
        // IncThread inc = new IncThread();
        // dec.start();
        // dec.join();
        // inc.start();
        // inc.join();
        // System.out.println("value: " + Counter.value);
    }
}


