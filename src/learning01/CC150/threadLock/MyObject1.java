package learning01.CC150.threadLock;

/**
 * Created by Katsura on 2017/3/29.
 */
public class MyObject1 {
    public static synchronized void foo(String name) {
        System.out.println("Thread " + name + ".foo(): starting");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + ".foo(): interrupted.");
        }
        System.out.println("Thread " + name + ".foo(): ending");
    }

    public static synchronized void bar(String name) {
        System.out.println("Thread " + name + ".bar(): starting");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + ".bar(): interrupted.");
        }
        System.out.println("Thread " + name + ".bar(): ending");
    }
}
