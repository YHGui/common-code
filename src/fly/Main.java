package fly;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            int time = sc.nextInt();
            int course = sc.nextInt();
            if (!map.containsKey(time)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(course);
                map.put(time, list);
            } else {
                ArrayList<Integer> temp = map.get(time);
                temp.add(course);
                map.put(time, temp);
            }
        }

        Iterator<Map.Entry<Integer, ArrayList<Integer>>> iterator = map.entrySet().iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, ArrayList<Integer>> entry = iterator.next();
            int key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();
            if (value.size() >  1) {
                count++;
                System.out.print(key);
                for (int val : value) {
                    System.out.print(" ");
                    System.out.print(val);
                }
            }
        }
        if (count == 0) {
            System.out.println("YES");
        }
    }
}
