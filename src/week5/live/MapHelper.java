package week5.live;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Katsura on 2017/3/1.
 */
public class MapHelper {
    public static <K, V> V get(Map61B<K, V> sim, K key) {
        if (sim.contains(key)) {
            return sim.get(key);
        }

        return null;
    }

    public static <K extends  Comparable<K>, V> K maxKey(Map61B<K, V> map) {
        List<K> keyList = map.keys();
        K largest = keyList.get(0);
        //keyList中有许多null值
        for (K k : keyList) {
            if (k == null) {
               return largest;
            } else if (k.compareTo(largest) > 0) {
                largest = k;
            }
        }

        return largest;
    }

    @Test
    public void testGet() {
        Map61B<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);
        Integer actual = MapHelper.get(m, "fish");
        Integer expected = 9;
        assertEquals(expected, actual);

        assertEquals(null, MapHelper.get(m, "awefawefawef"));
    }

    @Test
    public void testMaxKey() {
        Map61B<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);

        String actual = MapHelper.maxKey(m);
        String expected = "house";
        assertEquals(expected, actual);
    }
}
