package com.it.p1_anonymous_class;

public class Main {
    public static void main(String[] args) {
        // 用于接口
        new CanRun() {
            @Override
            public void run() {
                System.out.println("使用匿名类重写接口的方法");
            }
        }.run();

        // 用于抽象类
        new CanRunClass() {
            @Override
            void run() {
                System.out.println("使用匿名类重写抽象类的方法");
            }
        }.run();
    }
}

interface CanRun {
    void run();
}

abstract class CanRunClass {
    abstract void run();
}