package week5.live;

import java.util.ArrayList;

/**
 * Created by Katsura on 2017/3/1.
 */
public class BasicArrayList {
    public static void main(String[] args) {
        //必须使用封装类型或者引用类型(reference)(基本类型的包装类)
        // 而非基础类型(boolean, byte, short, char, int, long, float, double)
        ArrayList<String> L = new ArrayList<>();
        //ArrayList<String> L = new ArrayList<String>(); 在Java8中右边不再需要String
        L.add("potato");
        L.add("ketchup");
        String first = L.get(0);
    }
}
