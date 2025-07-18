package com.it.p2_threadSafe2;

public class DreawThread extends Thread {
    private Account account;
    public DreawThread(String name, Account ac) {
        super(name);
        account = ac;
    }

    @Override
    public void run() {
        account.draw(100000);
    }
}
