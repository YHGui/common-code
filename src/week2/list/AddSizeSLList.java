package week2.list;

/**
 * Created by Katsura on 2017/2/23.
 */
public class AddSizeSLList {
    public class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first;
    private int size;

    public AddSizeSLList() {
        first = null;
        size = 0;
    }

    public AddSizeSLList(int x) {
        first = new IntNode(x, first);
        size += 1;
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
        size += 1;
    }

    public void addLast(int x) {
        size += 1;

        if (first == null) {
            first = new IntNode(x, null);
            return;
        }

        IntNode p = first;
        while (p != p.next) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }

    public int getFirst() {
        if (first != null) {
            return first.item;
        }

        throw new NullPointerException("a empty node");
    }

}
