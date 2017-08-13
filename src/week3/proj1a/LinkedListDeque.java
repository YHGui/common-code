package week3.proj1a;

/**
 * Created by Katsura on 2017/2/27.
 */
public class LinkedListDeque<T> {
    public class IntNode {
        public T item;
        public IntNode next;
        public IntNode prev;

        public IntNode(T item, IntNode next, IntNode prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        public IntNode(T t) {
            next = prev = null;
            item = t;
        }

        @Override
        public String toString() {
            return item.toString();
        }

        public boolean equals(Object obj) {
            if (item == null)
                return obj == null;
            else if (obj != null)
                return item.equals(obj);
            else
                return false;
        }
    }

    private IntNode sentinel;
    private IntNode current;
    private int size;

    public LinkedListDeque() {
        sentinel = new IntNode(null);
        sentinel.next = sentinel.prev = sentinel;
        current = sentinel;
        size = 0;
    }

    //给定t，在当前位置后插入新节点
    //(如果当前节点为哨兵节点，新节点变成头节点)
    // 并使新节点为当前节点
    public void add(T t) {
        IntNode p = new IntNode(t);

        p.next = current.next;
        p.prev = current;
        current.next.prev = p;
        current.next = p;

        current = p;
        size += 1;
    }

    //移除当前节点
    // 后继节点变成当前节点
    public void remove() {
        //不删除哨兵节点
        if (current == sentinel) {
            System.err.println("Attempt to delete sentinel");
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;

            current = current.next;
            size -= 1;
        }
    }

    @Override
    public String toString() {
        String result = "";

        for (IntNode p = sentinel.next; p != sentinel; p = p.next) {
            result += p.toString() + "\n";
        }

        return result;
    }

    public void addFirst(T item) {
        current = sentinel;
        add(item);
    }

    public void addLast(T item) {
        current = sentinel.prev;
        add(item);
    }

    public boolean isEmpty() {
        return  size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        System.out.println(this);
    }

    public T removeFirst() {
        current = sentinel.next;
        if (current != sentinel) {
            T result = current.item;
            remove();
            return result;
        } else {
            return null;
        }
    }

    public T removeLast() {
        current = sentinel.prev;
        if (current != sentinel) {
            T result = current.item;
            remove();
            return result;
        } else {
            return null;
        }
    }

    public T get(int index) {
        if (index > size - 1) {
            return null;
        }

        IntNode p = sentinel;
        for (int count = 0; count <= index; count++) {
            p = p.next;
        }

        return p.item;
    }

    public T get() {
        if (current == sentinel) {
            System.err.println("No current item to return");
            return null;
        } else {
            return current.item;
        }
    }

    public void set(T t) {
        if (current == sentinel) {
            System.err.println("No current item to set");
        } else {
            current.item = t;
        }
    }

    public T getRecursive(int index) {

        return null;
    }

    public T next() {
        if (hasNext()) {
            current = current.next;
            return current.item;
        }
        else {
            System.err.println("No next item");
            return null;
        }
    }

    public boolean hasNext() {
        return current.next != sentinel;
    }

    public boolean contains(T t) {
        IntNode p;
        sentinel.item = t;
        for (p = sentinel.next; !p.item.equals(t);p = p.next);
        sentinel.item = null;
        if (p == sentinel) {
            return false;
        } else {
            current = p;
            return true;
        }
    }

}
