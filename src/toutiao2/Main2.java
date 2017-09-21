package toutiao2;

import java.util.*;

/**
 * Created by guiyonghui on 2017/9/10.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int seq = sc.nextInt();
        int color = sc.nextInt();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int count = sc.nextInt();
            for (int j = 0; j < count; j++) {
                list.add(sc.nextInt());
            }
            lists.add(list);
        }

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            ArrayList<Integer> tempList = lists.get(i);
            for (int value : tempList) {
                if (!map.containsKey(value)) {
                    map.put(value, new ArrayList<Integer>(i));
                } else {
                    ArrayList<Integer> temp = map.get(value);
                    temp.add(i);
                    map.put(value, temp);
                }
            }
        }

        int count = 0;

        Iterator<Map.Entry<Integer, ArrayList<Integer>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, ArrayList<Integer>> entry = iterator.next();
            ArrayList<Integer> value = entry.getValue();

            int size = value.size();
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if ((value.get(i) + seq) % num >= value.get(j)) {
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
