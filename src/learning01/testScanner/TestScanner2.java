package learning01.testScanner;

import java.util.Scanner;

/**
 * Created by Katsura on 2017/3/24.
 */
public class TestScanner2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useDelimiter("\\D");
        System.out.println("请输入当前日期（年-月-日）:");
        int year = scan.nextInt();
        int month = scan.nextInt();
        int date = scan.nextInt();
        System.out.println(year + " " + month + " " + date);
    }

}
