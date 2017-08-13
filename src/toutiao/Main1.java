package toutiao;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Katsura on 2017/4/18.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Long> input = new HashSet<>();
        while (sc.hasNext()){
            long element = sc.nextLong();
            if (element == 0) {
                break;
            }
            input.add(element);
        }
        int result = input.size();
        System.out.print(result);
    }
}
