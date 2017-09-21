package didi;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            if (arr[i] == 0) {
                count = count + 2;
            }

            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else  {
                int temp = map.get(arr[i]);
                map.put(arr[i], temp + 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int value = entry.getValue();
            if (value % 2 ==  0) {
                count++;
            }
        }

        System.out.println(count);

    }
}
