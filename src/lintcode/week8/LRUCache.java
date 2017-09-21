package lintcode.week8;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Katsura on 2017/3/21.
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            //accessOrder为true时，按照访问(get方法调用)顺序，调用之后会将这次访问的元素移至链表尾部，
            // 不断访问可以形成按访问顺序排序的链表
            //false则是按照插入顺序
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                System.out.println(eldest.getKey() + "=" + eldest.getValue());
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.set(5, 4);
        cache.set(7, 2);
        cache.set(6, 3);
        cache.set(1, 8);
        cache.set(8, 3);
        cache.set(9, 0);
    }


}
