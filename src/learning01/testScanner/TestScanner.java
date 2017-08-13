package learning01.testScanner;

import java.util.Scanner;

/**
 * Created by Katsura on 2017/3/24.
 */
public class TestScanner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入字符串：");
        while (true) {
            String line = s.nextLine();
            if (line.equals("exit")) {
                break;
            }
            System.out.println(">>>" + line);
        }
    }
}
