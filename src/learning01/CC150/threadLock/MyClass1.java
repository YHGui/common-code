package learning01.CC150.threadLock;

/**
 * Created by Katsura on 2017/3/29.
 */
public class MyClass1 extends Thread {
    private String name;
    private MyObject1 myObject;

    public MyClass1(String name, MyObject1 myObject) {
        this.name = name;
        this.myObject = myObject;
    }

    @Override
    public void run() {
        if(name.equals("1")) {
            MyObject1.foo(name);
        } else if (name.equals("2")) {
            MyObject1.bar(name);
        }
    }
}
