package learning01.CC150.threadLock;

/**
 * Created by Katsura on 2017/3/29.
 */
public class RunnableThreadExample implements Runnable{
    public int count = 0;

    @Override
    public void run() {
        System.out.println("RunnableThread starting");
        while (count < 5) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("RunnableThread interrupted");
            }
            count++;
        }
        System.out.println("RunnableThread terminating");
    }

    public static void main(String[] args) {
        RunnableThreadExample instance = new RunnableThreadExample();
        Thread thread = new Thread(instance);
        thread.start();
        while (instance.count != 5) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
