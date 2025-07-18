package com.it.p1_thread_test;

import java.util.ArrayList;

public class Task extends Thread{
    private final ArrayList<String> gift;
    private int count = 0;

    public Task(String name, ArrayList<String> gift) {
        super(name);
        this.gift = gift;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (gift) {
                if(gift.size() < 10) {
                    break;
                }
                gift.remove(gift.size() - 1);
                count++;
            }
        }
    }

    public int getCount() {
        return count;
    }
}
