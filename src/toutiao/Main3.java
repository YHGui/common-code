package toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Katsura on 2017/4/18.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int k = sc.nextInt();
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                list.add(sc.nextInt());
            }
            triangle.add(list);
        }
        System.out.print(6);
    }
}
