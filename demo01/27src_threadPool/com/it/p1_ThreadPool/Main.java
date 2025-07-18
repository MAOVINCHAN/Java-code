package com.it.p1_ThreadPool;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 代表线程池的接口： ExecutorService
 * 常见线程池的常用方法：
 * 1. 使用接口的实现类 ThreadPoolExecutor。
 *    public ThreadPoolExecutor(
 *      int corePoolSize, // 核心线程数量，主要处理任务的线程。
 *      int maximumPoolSize, // 线程池最大线程数量，假设核心线程3，最大线程5，多出的2为临时线程
 *      long keepAliveTime, // 指定临时线程的存活时间
 *      TimeUnit unit, // 指定临时线程存活时间的单位（秒，分，时，天）
 *      BlockingQueue<Runnable> workQueue, // 指定线程池的任务队列
 *      ThreadFactory threadFactory, // 指定创建线程的线程工厂
 *      RejectedExecutionHandler handler // 指定线程池的任务拒绝策略（线程都在忙，任务满了，新任务来了改怎么处理）
 *    )
 *
 *    // 常用任务队列
 *    - new ArrayBlockingQueue<>(int capacity);
 *
 *    // 常用拒绝策略
 *    - new ThreadPoolExecutor.AbortPolicy(): 多出的任务不执行且抛出异常
 *    - new ThreadPoolExecutor.DiscardPolicy(): 多出的任务不执行且不抛出异常
 *    - new ThreadPoolExecutor.DiscardOldestPolicy(): 丢弃最老的多出的任务。
 *    - new ThreadPoolExecutor.CallerRunsPolicy(): 核心线程满了，任务队列满了，由主线程执行
 *
 *    // 线程示例的常用方法
 *    - pool.execute(Runable target): 自动创建线程，自动执行target任务。
 *    - pool.shotdown() : 所有任务执行完成后关闭线程池
 *    - pool.shotdownNow(): 立即关闭线程池
 *    - Future<T> pool.submit(Callable target); 处理Callable任务，并返回处理的Future任务对象，可获取线程执行的返回值。
 *
 *    // 核心线程数配置参考：
 *    - 密集型计算任务，核心线程数量设置为 CPU核心数 + 1；
 *    - 密集型IO任务，核心线程数量设置为 CPU核心数 * 2；
 *
 * 2. 使用 Executors工具类提供的方法。
 * 【注意】大型并发项目不允许使用Executors工具类创建线程池，而是通过ThreadPoolExecutor的方式，这样可以让写代码的程序员更加明确执行规则，
 * 规避资源耗尽的风险。
 * - FixedThreadPool和SingleThreadPool允许请求队列的长度为Integer.MAX_VALUE，可能会堆积大量请求，导致OOM （内存溢出异常）；
 * - CachedThreadPool允许创建的线程数量为Integer.MAX_VALUE,可能会创建大量线程，导致OOM（内存溢出异常）。
 *
 */
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,
                5,
                8,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        // 核心线程执行 3
        pool.execute(new MyRunable("1"));
        pool.execute(new MyRunable("2"));
        pool.execute(new MyRunable("3"));

        // 任务队列 4
        pool.execute(new MyRunable("4"));
        pool.execute(new MyRunable("5"));
        pool.execute(new MyRunable("6"));
        pool.execute(new MyRunable("7"));

        // 达到临时线程的创建时机， 5 - 3 = 2 可创建
        pool.execute(new MyRunable("8"));
        pool.execute(new MyRunable("9"));

        // 达到任务拒绝时机，3核心占用，4队列占用，2临时占用
        pool.execute(new MyRunable("10"));

        // 线程池关闭方法，一般不使用
        // pool.shutdown();
    }
}
