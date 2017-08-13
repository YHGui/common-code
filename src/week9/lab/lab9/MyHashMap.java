package week9.lab.lab9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Katsura on 2017/3/5.
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    private static final int INIT_SIZE = 4;
    private static final double LOAD_FACTOR = 10;
    private int initialSize;
    private double loadFactor;
    private int keyValueNum;//键值对数目
    private int hashNum;//hash表大小
    private SequentialSearchST<K, V>[] st; //链表数组

    public MyHashMap() {
        this(INIT_SIZE, LOAD_FACTOR);
    }

    public MyHashMap(int initialSize) {
        this(initialSize, LOAD_FACTOR);
    }

    public MyHashMap(int initialSize, double loadFactor) {
        this.initialSize = initialSize;
        this.loadFactor = loadFactor;
        hashNum = initialSize;
        st = new SequentialSearchST[hashNum];
        for (int i = 0; i < hashNum; i++) {
            st[i] = new SequentialSearchST<K, V>();
        }
    }


    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }

    @Override
    public void clear() {
        st = null;
        keyValueNum = 0;
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    }

    private int hash(K key) {
        //保证为正数,0 ~ initialSize - 1
        return (key.hashCode() & 0x7fffffff) % hashNum;
    }

    @Override
    public int size() {
        return keyValueNum;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (value == null) {
            remove(key);
            return;
        }
        //键值对数目 / hash表数目 = loadFactor
        if (keyValueNum / hashNum > loadFactor) {
            resize();
        }

        int i = hash(key);
        if (!st[i].containsKey(key)){
            keyValueNum++;
        }
        st[i].put(key, value);

    }

    private void resize() {
        MyHashMap<K, V> temp = new MyHashMap<K, V>(2 * hashNum);
        for (int i = 0; i < hashNum; i++) {
            for (K key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.hashNum = temp.hashNum;
        this.keyValueNum = temp.keyValueNum;
        this.st = temp.st;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<K>();
        for (int i = 0; i < hashNum; i++) {
            for (K key : st[i].keys()) {
                set.add(key);
            }
        }
        return set;
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }
}
