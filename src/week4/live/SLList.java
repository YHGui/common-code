package week4.live;

/**
 * Created by Katsura on 2017/2/28.
 */
public class SLList<Blorp> implements List61B<Blorp> {

    public class Node {
        public Blorp item;
        public  Node next;

        public Node(Blorp i, Node h) {
            item = i;
            next = h;
        }

    }

    private Node sentinel;
    private int size;

    public SLList() {
        size = 0;
        sentinel = new Node(null, null);
    }

    public SLList(Blorp x) {
        size = 1;
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
    }

    @Override
    public void addLast(Blorp x) {
        size += 1;

        Node p = sentinel;

        while (p.next != null) {
            p = p.next;
        }

        p.next = new Node(x, null);
    }

    private Node getLastNode() {
        Node p = sentinel;

        while (p.next != null) {
            p = p.next;
        }

        return p;
    }

    @Override
    public Blorp getLast() {
        Blorp result = null;
        Node p = getLastNode();
        result = p.item;

        return result;
    }

    @Override
    public Blorp get(int index) {
        if (index == 0) {
            return getFirst();
        }
        Node currentNode = sentinel.next.next;

        while (index > 1 && currentNode.next != null) {
            index -= 1;
            currentNode = currentNode.next;
        }

        return currentNode.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Blorp removeLast() {
        Node back = getLastNode();
        Blorp result = back.item;
        if (back == sentinel) {
            result = null;
        }
        Node p = sentinel;

        while (p.next != back) {
            p = p.next;
        }
        p.next = null;
        size -= 1;

        return result;
    }

    @Override
    public void insert(Blorp x, int position) {
        if (position == 0 || sentinel.next ==null) {
            addFirst(x);
            return;
        }

        Node currentNode = sentinel.next.next;
        while (position > 1 && currentNode.next != null) {
            position -= 1;
            currentNode = currentNode.next;
        }

        Node newNode = new Node(x, currentNode.next);
        currentNode.next = newNode;

    }

    @Override
    public void addFirst(Blorp x) {
        sentinel.next = new Node(x, sentinel.next);
        size += 1;
    }

    @Override
    public Blorp getFirst() {
        return sentinel.next.item;
    }
}
