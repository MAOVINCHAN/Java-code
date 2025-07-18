package com.it.comminIo;

import org.apache.commons.io.*;
import java.io.File;
import java.io.IOException;

/**
 *  1. 下载org.apache.commons相关jar包；
 *  2. 创建文件夹 lib，并放入下载的jar包；
 *  3. 右键lib文件夹 -> Add as library
 *  4. 即可在项目中正常引入使用了。
 */

public class CommonIoTest {
    public static void main(String[] args) {
        try {
            // FileUtils.copyFile(new File("test01.txt"), new File("test04.txt"));
            // FileUtils.delete(new File("test04.txt"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
