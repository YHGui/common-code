package learning01.testScanner;

import java.util.Scanner;

/**
 * Created by Katsura on 2017/3/24.
 */
public class Ou {
    public static void main(String[] args) {
        System.out.println("请输入一个整数： ");
        Scanner reader = new Scanner(System.in);
        long a = reader.nextLong();
        String str = (a % 2) == 0 ? "偶数" : "奇数";
        System.out.println("结果是：" + str);
    }
}
