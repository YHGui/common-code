package swordOffer.Problem2;

public class Singleton1 {

    //饿汉式

    //一开始就已经生成了唯一的单例实例对象
    private static final Singleton1 singleton1 = new Singleton1();

    //构造器私有化，使得外部不能使用该类来生成对象
    private Singleton1(){}

    //静态方法得到实例对象
    public static Singleton1 getInstance() {
        return singleton1;
    }
}
