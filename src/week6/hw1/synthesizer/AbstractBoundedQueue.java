package week6.hw1.synthesizer;

/**
 * Created by Katsura on 2017/3/2.
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T>{

    abstract void moveTo(double deltaX, double deltaY);

    protected int fillCount;
    protected int capacity;

    public int capacity() {
        return capacity;
    }

    public int fillCount() {
        return fillCount;
    }

    public boolean isEmpty() {
        return  fillCount() == 0;
    }
    public boolean isFull() {
        return fillCount() == capacity();
    }

    public abstract T peek();
    public abstract T dequeue();
    public abstract void enqueue(T x);
}
