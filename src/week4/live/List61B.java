package week4.live;

/**
 * Created by Katsura on 2017/2/28.
 */
public interface List61B<Item> {

    public void addLast(Item x);

    public Item getLast();

    public Item get(int i);

    public int size();

    public Item removeLast();

    public void insert(Item x, int position);

    public void addFirst(Item x);

    public Item getFirst();

    default public void print() {
        for (int i = 0; i < size(); i = i + 1) {
            System.out.print(get(i) + " ");
        }
    }
}
