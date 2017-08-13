package week3.list;

/**
 * Created by Katsura on 2017/2/24.
 */
public class AList {
    private int[] items;
    private int size;
    private final double RFACTOR = 1.5;

    public AList() {
        items = new int[100];
        size = 0;
    }

    public void addLast(int x) {

        if(size == items.length) {
            int[] a = new int[size + 1];
            System.arraycopy(items, 0, a, 0, size);
            items = a;
        }
        items[size] = x;
        size += 1;
    }

    private void resize(int capacity) {
        int[] a = new int[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void insertBack(int x) {
        if (size == items.length) {
            //resize(size + 1); 扩容太慢，效率低下
            resize((int)(size * RFACTOR));
        }
        items[size] = x;
        size += 1;
    }

    public int getLast() {
        return items[size - 1];
    }

    public int get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    public int removeLast() {
        int returnItem = items[size - 1];
        items[size - 1] = 0;
        size -= 1;
        return returnItem;
    }


}
