package week4.proj1b.katsura;

/**
 * Created by Katsura on 2017/3/1.
 */
public interface Deque<T> {
    public void addFirst(T t);

    public void addLast(T t);

    public T get(int index);

    public int size();

    public boolean isEmpty();

    public void printDeque();

    public T removeFirst();

    public T removeLast();
}
