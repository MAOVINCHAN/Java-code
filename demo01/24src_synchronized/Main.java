/**
 *
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Mythread1 mt1 = new Mythread1();
        mt1.start();
        mt1.join();
        Mythread2 mt2 = new Mythread2();
        mt2.start();
        mt2.join();

        System.out.println("count is: " + Counter.count);
    }
}

class Counter {
    public static final Object lock = new Object();
    public static int count = 0;
}

class Mythread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (Counter.lock) {
                Counter.count++;
            }
        }
    }
}

class Mythread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1001; i++) {
            synchronized (Counter.lock) {
                Counter.count--;
            }
        }
    }
}
