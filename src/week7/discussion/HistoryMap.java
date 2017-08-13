package week7.discussion;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Katsura on 2017/3/3.
 */

//HashMap的put和remove操作使用undo将变为可逆
// 其中put操作是在map中有该key时则逆向操作时不能remove，而如果没有该key时，逆向操作则remove
// 而remove的逆向操作则是重新put，此时直接将记下的key和value直接put
// 这些操作借用Stack
public class HistoryMap<K, V> extends HashMap<K, V>  {
    Stack<Operation> history = new Stack<>();
    class Operation {
        boolean shouldRemove;
        K key;
        V value;

        public Operation(boolean shouldRemove, K key, V value) {
            this.shouldRemove = shouldRemove;
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public V put(K key, V value) {
        history.push(new Operation(!containsKey(key), key, value));
        return super.put(key, value);
    }

    @Override
    public V remove(Object key) {
        history.push(new Operation(false, (K)key, get(key)));
        return super.remove(key);
    }

    @Override
    public boolean containsKey(Object key) {
        return super.containsKey(key);
    }

    public void undo() {
        if (history.isEmpty()) {
            return;
        }

        Operation op = history.pop();
        if (op.shouldRemove) {
            super.remove(op.key);
        } else {
            super.put(op.key, op.value);
        }
    }

    public static void main(String[] args) {
        HistoryMap<String, Integer> h = new HistoryMap<>();
        h.put("party", 1);
        h.put("parrot", 2);
        h.put("conga", 4);
        h.put("parrot", 3);
        h.undo();
        h.undo();
        System.out.println(h); // Output: {parrot=2, party=1}
        h.remove("party");
        h.undo();
        System.out.println(h); // Output: {parrot=2, party=1}
    }
}
