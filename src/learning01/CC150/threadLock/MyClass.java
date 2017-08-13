package learning01.CC150.threadLock;

/**
 * Created by Katsura on 2017/3/29.
 */
public class MyClass extends Thread {
    private String name;
    private MyObject myObject;

    public MyClass(String name, MyObject myObject) {
        this.name = name;
        this.myObject = myObject;
    }

    @Override
    public void run() {
        myObject.foo(name);
    }
}
