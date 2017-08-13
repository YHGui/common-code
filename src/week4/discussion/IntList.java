package week4.discussion;

/**
 * Created by Katsura on 2017/2/28.
 */
public class IntList {
    public int head;
    public IntList tail;
    public IntList(int i, IntList n) {
        head = i;
        tail = n;
    }

    public static void main(String[] args) {
        IntList a = new IntList(5, null);
        System.out.println(a.head);
        IntList b = new IntList(9, null);
        IntList c = new IntList(1, new IntList(7, b));
        a.tail = c.tail;
        a.tail.tail = b;
        b.tail = c.tail;
        IntList d = new IntList(9002, b.tail.tail);
        System.out.println(d.tail.tail.tail.head);
        System.out.println(a.tail.head);
        c.tail.tail = c.tail;
        System.out.println(a.tail.tail.tail.tail.head);
    }

}
