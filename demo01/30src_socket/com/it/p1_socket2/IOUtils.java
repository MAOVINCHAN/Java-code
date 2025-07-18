package com.it.p1_socket2;

import java.io.Closeable;
import java.io.IOException;

public class IOUtils {
    public static void closeAll(Closeable ...closeables) {
        for (Closeable it :
                closeables) {
            if(it != null) {
                try {
                    it.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
