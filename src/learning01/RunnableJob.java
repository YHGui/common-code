package learning01;

import java.util.Date;

/**
 * Created by Katsura on 2017/3/13.
 */
public class RunnableJob implements Runnable {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " start " + " at " + new Date());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //线程在睡眠中被interrupt，可以抛出InterruptedException，属于checked Exception因此需要try catch
        // 而且线程的休眠不会导致锁的释放
        System.out.println(thread.getName() + " end " + " at " + new Date());
    }

    public static void main(String[] args) throws InterruptedException{
        RunnableJob runnableJob = new RunnableJob();
        Thread T1 = new Thread(runnableJob, "T1");
        Thread T2 = new Thread(runnableJob, "T2");
        Thread T3 = new Thread(runnableJob, "T3");

        T1.start();
        T1.join();
        T2.start();
        T2.join();
        T3.start();
        T3.join();
    }
}
