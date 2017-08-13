package learning01.CC150.threadLock;

/**
 * Created by Katsura on 2017/3/29.
 */
public class SynchronizedTest {
    public static void main(String[] args) {
//        MyObject object1 = new MyObject();
//        MyObject object2 = new MyObject();
//        MyClass thread1 = new MyClass("1", object1);
//        MyClass thread2 = new MyClass("2", object2);
//        thread1.start();
//        thread2.start();
//        MyObject object = new MyObject();
//        MyClass thread1 = new MyClass("1", object);
//        MyClass thread2 = new MyClass("2", object);
//        thread1.start();
//        thread2.start();
        //静态方法会以类锁(class lock)进行同步，因此两个线程无法同步执行同一个类的同步静态方法，即使其中一个线程调用foo方法，
        // 而另一个线程调用bar也不行
        MyObject1 object = new MyObject1();
        MyClass1 thread1 = new MyClass1("1", object);
        MyClass1 thread2 = new MyClass1("2", object);
        thread1.start();
        thread2.start();
    }
}
