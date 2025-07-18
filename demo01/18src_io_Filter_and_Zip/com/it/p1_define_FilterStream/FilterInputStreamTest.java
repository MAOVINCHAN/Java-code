package com.it.p1_define_FilterStream;

import java.io.*;

public class FilterInputStreamTest {
    public static void main(String[] args) {
        try (
                // 1. 使用字节输入流连接文件
                FileInputStream fis = new FileInputStream("test01.txt");
                ) {
            //2. 使用自定义 FilterInputStream
            ConuntInputStream cis = new ConuntInputStream(fis);

            int n;
            while ((n = cis.read()) != -1) {
                System.out.print((char) n);
            }

            System.out.println();

            System.out.println("file count: " + cis.getByteCount());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class ConuntInputStream extends FilterInputStream {
    private int count = 0;

    protected ConuntInputStream(InputStream in) {
        super(in);
    }

    public int getByteCount() {
        return count;
    }

    @Override
    public int read() throws IOException {
        int n = in.read();
        if(n != -1) count++;
        return  n;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int n = in.read(b, off, len);
        if(n != -1) count++;
        return n;
    }
}