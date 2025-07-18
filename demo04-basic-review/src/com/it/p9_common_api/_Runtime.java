package com.it.p9_common_api;

public class _Runtime {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime(); // runtime全局只能有一个对象，不可通过new创建
        // 获取可用于虚拟机的处理器数量
        System.out.println(runtime.availableProcessors()); // 8
        // 返回Java虚拟机中的可用内存量。
        System.out.println(runtime.freeMemory()); // 263316192 byte

        // 执行命令
        // runtime.exec();

        // 返回Java虚拟机将尝试使用的最大内存量。
        System.out.println(runtime.maxMemory() / 1024 / 1024);
        // 返回Java虚拟机中的内存总量。
        System.out.println(runtime.totalMemory() / 1024 / 1024);
        // 退出java虚拟机
        runtime.exit(0); // System.exit()其实就是调用runtime.exit()方法
    }
}
