package week2.list;

/**
 * Created by Katsura on 2017/2/24.
 */
public class SentinelSLList {
    private static class IntNode{
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public SentinelSLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SentinelSLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {
        size = size + 1;

        IntNode p = sentinel;

        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SentinelSLList sentinelSLList = new SentinelSLList();
        sentinelSLList.addLast(20);
        System.out.println(sentinelSLList.size());
    }


}
