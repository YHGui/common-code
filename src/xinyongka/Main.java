package xinyongka;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] voteString = sc.nextLine().split(" ");
        String[] weightString = sc.nextLine().split(" ");
        int[] vote = new int[voteString.length];
        int[] weight = new int[weightString.length];

        int len = vote.length;
        for (int i = 0; i < len; i++) {
            vote[i] = Integer.valueOf(voteString[i]);
            weight[i] = Integer.valueOf(weightString[i]);
        }
        HashMap<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(vote[i])) {
                map.put(vote[i], new Pair(1, weight[i]));
            } else {
                Pair temp = map.get(vote[i]);
                map.put(vote[i], new Pair(temp.num + 1, temp.score + weight[i]));
            }
        }
        Pair max = new Pair(0, 0);
        int maxIndex = 0;
        Iterator<Map.Entry<Integer, Pair>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Pair> entry = iterator.next();
            Pair value = entry.getValue();
            int key = entry.getKey();
            if (value.score > max.score) {
                max = value;
                maxIndex = key;
            } else if (value.score == max.score && value.num > max.num) {
                max = value;
                maxIndex = key;
            }
        }

        System.out.println(maxIndex);

    }
}
class Pair {
    public int num;
    public int score;

    public Pair(int num, int score) {
        this.num = num;
        this.score = score;
    }

}
