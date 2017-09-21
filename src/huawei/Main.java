package huawei;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int[] arr = new int[str.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.valueOf(str[i]);
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                int temp = map.get(arr[i]);
                map.put(arr[i], temp + 1);
            }
        }
        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();

        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            int key = entry.getKey();
            int value = entry.getValue();
            sb.append(key);
            sb.append(" ");
            sb.append(value);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
