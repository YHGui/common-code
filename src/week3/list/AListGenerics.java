package week3.list;

/**
 * Created by Katsura on 2017/2/24.
 */
public class AListGenerics<Glorp> {
    private Glorp[] items;
    private int size;
    private final double RFACTOR = 1.5;

    public AListGenerics() {
        items = (Glorp[]) new Object[8];
        size = 0;
    }

    private void resize(int cap) {
        Glorp[] a = (Glorp[]) new Object[cap];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void insertBack(Glorp x) {
        if (size == items.length) {
            //resize(size + 1); 扩容太慢，效率低下
            resize((int)(size * RFACTOR));
        }
        items[size] = x;
        size += 1;
    }

    public Glorp getLast() {
        return items[size - 1];
    }

    public Glorp get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    public Glorp deleteBack() {
        Glorp returnItem = getLast();
        items[size - 1] = null;
        size -= 1;

        return returnItem;
    }

}
