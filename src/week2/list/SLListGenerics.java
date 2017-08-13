package week2.list;

/**
 * Created by Katsura on 2017/2/24.
 */
public class SLListGenerics<LochNess> {

    private class StuffNode {

        public LochNess item;
        public StuffNode next;

        public StuffNode(LochNess i, StuffNode n) {
            item = i;
            next = n;
        }
    }

    private StuffNode first;
    private int size;

    public SLListGenerics(LochNess x) {
        first = new StuffNode(x, null);
        size = 1;
    }

    /** Adds x to the front of the list. */
    public void addFirst(LochNess x) {
        first = new StuffNode(x, first);
        size += 1;
    }

    /** Returns the first item in the list. */
    public LochNess getFirst() {
        return first.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(LochNess x) {
        size += 1;

        StuffNode p = first;

 		/* Move p until it reaches the end of the list. */
        while (p.next != null) {
            p = p.next;
        }

        p.next = new StuffNode(x, null);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLListGenerics<String> s1 = new SLListGenerics<>("bone");
        s1.addFirst("thugs");
        System.out.println(s1.size());
    }
}
