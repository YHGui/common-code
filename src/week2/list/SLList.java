package week2.list;

/**
 * Created by Katsura on 2017/2/23.
 */
public class SLList {
    //public IntNode first;
    private IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void addLast(int x) {
        IntNode p = first;

        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }

    public int getFirst() {
        return first.item;
    }

    private int size(IntNode p) {
        if (p.next == null) {
            return 1;
        }

        return 1 + size(p.next);
    }

    public int size() {
       return size(first);
    }

    public static void main(String[] args) {
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        int x = L.getFirst();
        System.out.println(x);
    }
}
