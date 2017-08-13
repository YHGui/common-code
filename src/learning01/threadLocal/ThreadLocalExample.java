package learning01.threadLocal;

/**
 * Created by Katsura on 2017/3/15.
 */
public class ThreadLocalExample {
    public static class MyRunnable implements Runnable {
        private ThreadLocal threadLocal = new ThreadLocal();
        @Override
        public void run() {
            threadLocal.set((int)(Math.random() * 1000));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);

        t1.start();
        t2.start();
    }
}
