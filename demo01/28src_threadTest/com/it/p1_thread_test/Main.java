package com.it.p1_thread_test;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> gift = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            gift.add("礼物" + (i + 1));
        }


        Task ming = new Task("ming", gift);
        ming.start();

        Task hong = new Task("hong", gift);
        hong.start();

        ming.join();
        hong.join();

        System.out.println("小明发了" + ming.getCount());
        System.out.println("小红发了" + hong.getCount());
    }
}
