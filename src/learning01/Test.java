package learning01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Katsura on 2017/3/20.
 */
public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("apple", "苹果");
        map.put("watermelon", "西瓜");
        map.put("banana", "香蕉");
        map.put("peach", "桃子");

        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println(" ");
        //accessOrder:true按照访问顺序迭代，默认为false，按照插入顺序迭代
        //LinkedHashMap增加了一个header Entry和before、after Entry
        Map<String, String> map1 = new LinkedHashMap<>(16, 0.75f, true);
        map1.put("apple", "苹果");
        map1.put("watermelon", "西瓜");
        map1.put("banana", "香蕉");
        map1.put("peach", "桃子");
        map1.get("banana");
        map1.get("apple");

        Iterator iterator1 = map1.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry entry1 = (Map.Entry)iterator1.next();
            System.out.println(entry1.getKey() + " = " + entry1.getValue());
        }
    }
//    public static void main(String[] args) {
//        Thread t = new Thread(){
//            public void run() {
//                print();
//            }
//        };
//        //t.run()没有开启线程
//        t.run();
//        System.out.print("MT");
//
//    }
//
//    public static void print() {
//        System.out.print("DP");
//    }
}
