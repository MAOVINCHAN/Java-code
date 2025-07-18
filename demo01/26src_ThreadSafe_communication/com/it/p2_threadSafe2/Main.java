package com.it.p2_threadSafe2;

public class Main {
    public static void main(String[] args) {
        Account account = new Account("ICBC-1", 100000);
        new DreawThread("小明", account).start();
        new DreawThread("小红", account).start();
    }
}
