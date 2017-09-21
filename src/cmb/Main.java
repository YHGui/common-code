package cmb;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int edge = sc.nextInt();

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < num; i++) {
            String key = sc.next();
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                String str = sc.next();
                if (!str.equals("*")) {
                    list.add(str);
                }
            }
            map.put(key, list);
        }

        ArrayList<String> result = new ArrayList<>();

        Iterator<Map.Entry<String, ArrayList<String>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<String>> entry = iterator.next();
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();

            if (value.size() >= 2) {
                result.add(key);
            } else if (getNum(map, key) >= 2) {
                result.add(key);
            } else {
                continue;
            }
        }

        for(String str : result) {
            System.out.print(str);
            System.out.print(" ");
        }

    }

    public static int getNum(HashMap<String, ArrayList<String>> map, String str) {
        ArrayList<String> list = map.get(str);
        if (list == null) {
            return 1;
        }
        if (list.size() > 1) {
            return getNum(map, map.get(str).get(0)) + getNum(map, map.get(str).get(1));
        } else {
            return getNum(map, map.get(str).get(0));
        }
    }


}
