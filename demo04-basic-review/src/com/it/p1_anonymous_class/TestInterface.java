package com.it.p1_anonymous_class;

public class TestInterface {
    public static void main(String[] args) {
        new Runable() {
            @Override
            public void run(String msg) {
                System.out.println(msg);
            }
        }.run("使用匿名类实现接口");

        new Fun().run("通过实例调用实现的run方法");
    }
}

class Fun implements Runable {
    @Override
    public void run(String msg) {
        System.out.println(msg);
    }
}

/**
 * 属性默认都是public final
 * 方法默认都是public abstract
 */
interface Runable {
    String name = null;
    void run(String msg);
}

