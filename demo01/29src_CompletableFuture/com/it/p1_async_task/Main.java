package com.it.p1_async_task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 使用 Future.get()会阻塞代码执行
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main start...");
        Task task = new Task();
        FutureTask<String> ft = new FutureTask<>(task);
        Thread thread = new Thread(ft);
        thread.run();
        String res = ft.get(); // 此处会阻塞代码

        System.out.println("res is: " + res);

        System.out.println("main end...");
    }
}
