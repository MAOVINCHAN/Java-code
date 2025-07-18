import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 线程创建方式三,获取线程运行的返回值
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 2.将实现的类包装成FutureTask对象，作为任务对象
        Task task = new Task(1000);
        FutureTask<String> futureTask = new FutureTask<>(task);

        // 3.将任务对象，放到线程内
        Thread thread = new Thread(futureTask);
        thread.start();

        // 4.获取返回值
        String res = futureTask.get();
        System.out.println(res);


        /**
         * 线程相关方法
         */
        // 1. 获取当前线程
        Thread currentThread = Thread.currentThread();
        // 2. 设置线程名字
        currentThread.setName("主线程");
        // 3. 获取线程名字
        System.out.println(currentThread.getName());
        // 4. 线程休眠
        Thread.sleep(1000); // 休眠1s
        // 5. 让调用join方法的线程优先执行完
        thread.join();
    }
}

// 1.实现Callable接口，重新call方法
class Task implements Callable<String> {
    private int n;

    public Task(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        int n = 0;
        for (int i = 1; i < this.n; i++) {
            n = n + i;
        }
        return "求出的1~" + this.n + "的和是：" + n;
    }
}