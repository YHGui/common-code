package week5.live;

import java.util.List;

/**
 * Created by Katsura on 2017/3/1.
 */
public interface Map61B<K, V> {

    boolean contains(K key);

    V get(K key);

    int size();

    void put(K key, V value);

    List<K> keys();
}
