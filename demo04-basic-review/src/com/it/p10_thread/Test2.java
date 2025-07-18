package com.it.p10_thread;

import java.util.LinkedList;

// 线程的状态
public class Test2 {
    public static void main(String[] args) throws InterruptedException {

    }
}

class TaskQueue {
    private LinkedList<String> task = new LinkedList<>();

    public synchronized void setTask(String s) {
        task.add(s);
    }

    public synchronized String getTask() {
        while (task.isEmpty()) {}
        return task.remove();
    }
}
