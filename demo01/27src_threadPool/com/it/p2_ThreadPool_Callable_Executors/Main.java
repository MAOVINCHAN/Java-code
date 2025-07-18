package com.it.p2_ThreadPool_Callable_Executors;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 方式一创建线程池
        // ThreadPoolExecutor pool = new ThreadPoolExecutor(
        //         3,
        //         5,
        //         8,
        //         TimeUnit.SECONDS,
        //         new ArrayBlockingQueue<>(4),
        //         Executors.defaultThreadFactory(),
        //         new ThreadPoolExecutor.CallerRunsPolicy()
        // );

        /**
         * 方式二使用Executors工具类提供的方法创建线程池
         *  - Executors.newFixedThreadPool(1); // 创建固定核心线程的线程池
         *  - Executors.newSingleThreadExecutor(); // 创建只有一个核心线程的线程池，这个线程挂了以后会自动重新创建一个核心线程
         *  - Executors.newCachedThreadPool(); // 核心线程数随任务数自动增减
         *  - Executors.newScheduledThreadPool(2); // 创建一个线程池，可以实现给定延迟后执行任务或定期执行任务。
         */
        ExecutorService pool = Executors.newFixedThreadPool(3);

        Future<String> p1 = pool.submit(new MyCallable(10));
        Future<String> p2 = pool.submit(new MyCallable(10));
        Future<String> p3 = pool.submit(new MyCallable(10));

        Future<String> p4 = pool.submit(new MyCallable(10));

        System.out.println(p1.get());
        System.out.println(p2.get());
        System.out.println(p3.get());
        System.out.println(p4.get());
    }
}
