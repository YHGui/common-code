package week5.live;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katsura on 2017/3/1.
 */
public class ArrayMap<K, V> implements Map61B<K, V>, Iterable<K>{
    private K[] keys;
    private V[] values;
    private int size;

    public ArrayMap() {
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    public class KeyIterator implements Iterator<K>{
        private int ptr;
        public KeyIterator() {
            ptr = 0;
        }

        public boolean hasNext() {
            return (ptr != size);
        }

        public K next() {
            K returnItem = keys[ptr];
            ptr += 1;

            return returnItem;
        }
    }

    @Override
    public Iterator<K> iterator() {
        return new KeyIterator();
    }

    @Override
    public boolean contains(K key) {
        int index = keyIndex(key);

        return index > -1;
    }

    private int keyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int index = keyIndex(key);

        return values[index];
    }

    @Override
    public int size() {
        return size;
    }

    //if k = -1, adds k and v to the last position of arrays
    @Override
    public void put(K key, V value) {
        int index = keyIndex(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size += 1;
            return;
        }

        values[index] = value;
    }

    @Override
    public List<K> keys() {
        List<K> keyList = new ArrayList<K>();
        for (int i = 0; i < keys.length; i++) {
            keyList.add(keys[i]);
        }

        return keyList;
    }

    public static void main(String[] args) {
        ArrayMap<String, Integer> am = new ArrayMap<String, Integer>();
        am.put("horse", 3);
        am.put("fish", 9);
        am.put("house", 10);

//        ArrayMap.KeyIterator ami = am.new KeyIterator();
//
//        while (ami.hasNext()) {
//            System.out.println(ami.next());
//        }
    }
}
