package com.it.p1_async_task;

import java.util.concurrent.*;

public class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

        ScheduledFuture<?> schedule = ses.schedule(() -> {
            int i = 0;
            for (int j = 0; j < 100; j++) {
                i += j;
            }
            return i;
        }, 1000, TimeUnit.MILLISECONDS);

        return "" +  schedule.get();
    }
}
