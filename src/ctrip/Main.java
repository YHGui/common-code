package ctrip;

import java.util.Scanner;

/**
 * Created by Katsura on 2017/4/10.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            int index;
            boolean flag = false;
            for ( index = first; index <= second; index++) {
                if (index == sum(index)) {
                    flag = true;
                    if (index != second) {
                        System.out.print(index + " ");
                    } else {
                        System.out.println(index);
                    }
                }
            }
            if (!flag) {
                System.out.println("no");
            }
        }
    }

    private static int sum(int num) {
        int result = 0;
        while (num / 10 != 0) {
            int number = num % 10;
            result = result + number * number * number;
            num = num / 10;
        }
        result += num * num * num;
        return result;
    }

}
