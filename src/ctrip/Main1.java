package ctrip;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Katsura on 2017/4/10.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double number = sc.nextInt();
            int count = sc.nextInt();
            ArrayList<Double> arr = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                arr.add((double)number);
                number = Math.sqrt(arr.get(arr.size() - 1));
            }
            double sum = 0.0;
            for (double element : arr) {
                sum += element;
            }
            System.out.println(String.format("%.2f", sum));
        }
    }
}
