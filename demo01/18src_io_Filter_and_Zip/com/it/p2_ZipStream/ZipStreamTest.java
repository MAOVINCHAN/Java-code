package com.it.p2_ZipStream;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipStreamTest {
    public static void main(String[] args) {
        try (
                FileInputStream fis = new FileInputStream("test02.zip");

                ZipInputStream zis = new ZipInputStream(fis);
                ){
            ZipEntry nextEntry = null;

            while ((nextEntry = zis.getNextEntry()) != null) {
                if(!nextEntry.isDirectory()) {
                    int n;
                    while ((n = zis.read()) != -1) {
                        System.out.print((char) n);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void writeToZip() {
        File file = new File("test01.txt");

        try (
                FileOutputStream fos = new FileOutputStream("test03.zip");

                ZipOutputStream zos = new ZipOutputStream(fos);

                // FileInputStream fis = new FileInputStream(file.getAbsoluteFile())
        ){
            // 1. 创建zip entry
            ZipEntry entry = new ZipEntry(file.getName());
            // 2. 将entry 放入 zip包
            zos.putNextEntry(entry);
            // 3. 将文件字节写入 zip
            zos.write(Files.readAllBytes(file.toPath()));

            // 或使用 input stream
            // byte[] bytes = new byte[1024];
            // int len;
            // while ((len = fis.read(bytes)) != -1) {
            //     zos.write(bytes,0, len);
            // }

            // 4. 关闭entry
            zos.closeEntry();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
