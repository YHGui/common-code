package week4.live;

/**
 * Created by Katsura on 2017/2/28.
 */
public class VengefulSLList<Item> extends SLList<Item> {
    private SLList<Item> deletedItems;
    public VengefulSLList() {
        //所有子类构造器初始化时先自动调用父类构造器
        // 因此可以用super()显式调用
        super();
        deletedItems = new SLList<Item>();
    }

    //编译时变量(compile-time)又称静态变量，会做类型检查，是否满足is-a以及是否包含某方法
    // 而编译时变量包括表达式使用new时，满足“=右is a/an =左”
    // 运行时变量(run-time)又称动态变量，在运行时确定其具体方法和类型
    //override覆盖方法的选择依赖于动态类型，其他都依赖于静态类型
    @Override
    public Item removeLast() {
        Item oldBack = super.removeLast();
        deletedItems.addLast(oldBack);
        return oldBack;
    }

    public void printLostItems() {
        deletedItems.print();
    }
}
