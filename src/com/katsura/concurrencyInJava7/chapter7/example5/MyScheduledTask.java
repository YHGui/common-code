package com.katsura.concurrencyInJava7.chapter7.example5;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by Katsura on 2017/4/17.
 */
public class MyScheduledTask<V> extends FutureTask<V>
        implements RunnableScheduledFuture<V> {
    private RunnableScheduledFuture<V> task;
    private ScheduledThreadPoolExecutor executor;
    private long period;
    private long startDate;

    public MyScheduledTask(Runnable runnable, V result,
                           RunnableScheduledFuture<V> task,
                           ScheduledThreadPoolExecutor executor) {
        super(runnable, result);
        this.task = task;
        this.executor = executor;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        if (!isPeriodic()) {
            return task.getDelay(unit);
        } else {
            if (startDate == 0) {
                return task.getDelay(unit);
            } else {
                Date now = new Date();
                long delay = startDate - now.getTime();
                return unit.convert(delay, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override
    public boolean isPeriodic() {
        return task.isPeriodic();
    }

    @Override
    public int compareTo(Delayed o) {
        return task.compareTo(o);
    }

    @Override
    public void run() {
        if (isPeriodic() && !executor.isShutdown()) {
            Date now = new Date();
            startDate = now.getTime() + period;
            executor.getQueue().add(this);
        }
        System.out.printf("Pre-MyScheduledTask: %s\n", new Date());
        System.out.printf("MyScheduledTask: Is Periodic: %s\n", isPeriodic());
        super.runAndReset();
        System.out.printf("Post-MyScheduledTask: %s\n", new Date());
    }

    public void setPeriod(long period) {
        this.period = period;
    }
}
