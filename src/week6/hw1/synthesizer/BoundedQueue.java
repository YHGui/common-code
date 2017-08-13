package week6.hw1.synthesizer;

/**
 * Created by Katsura on 2017/3/2.
 */
public interface BoundedQueue<T> {
    int capacity();

    int fillCount();

    void enqueue(T x);

    T dequeue();

    T peek();

    //default方法是指在接口内部包含了一些默认的方法实现，也就是接口中可以保护方法体，
    //从而使得接口在进行扩展的时候，不会破坏与接口相关的实现类代码
    default boolean isEmpty() {
        return fillCount() == 0;
    };

    default boolean isFull() {
        return capacity() == fillCount();
    }
}
