package week9.lab.lab9;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Katsura on 2017/3/5.
 */
public class SequentialSearchST<K, V> {
    private int n;//键值对的数量
    private Node first;

    private class Node {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public SequentialSearchST() {
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public V get(K key) {
        for (Node node = first; node != null; node = node.next) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    public void put(K key, V value) {
        if (value == null) {
            delete(key);
            return;
        }

        for (Node node = first; node != null; node = node.next) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        n++;
    }

    /**
     * Removes the key and associated value from the symbol table
     * (if the key is in the symbol table).
     * @param key the key
     */
    public Node delete(K key) {
        first = delete(first, key);
        return first;
    }

    // delete key in linked list beginning at Node x
    // warning: function call stack too large if table is large
    private Node delete(Node x, K key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public Set<K> keys() {
        Set<K> set = new HashSet<K>();
        for (Node node = first; node != null; node = node.next) {
            set.add(node.key);
        }
        return set;
    }

}
