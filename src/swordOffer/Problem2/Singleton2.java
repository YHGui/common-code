package swordOffer.Problem2;

public class Singleton2 {

    //懒汉式
    //最开始不创建对象
    private static Singleton2 singleton2 = null;

    //构造器私有化
    private Singleton2() {}

    public static Singleton2 getInstance() {
        if (singleton2 == null) {
            synchronized (Singleton2.class) {
                if (singleton2 == null) {
                    singleton2 = new Singleton2();
                }
            }
        }

        return singleton2;
    }
}
