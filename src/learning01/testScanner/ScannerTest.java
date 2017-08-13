package learning01.testScanner;

import java.util.Scanner;

/**
 * Created by Katsura on 2017/3/24.
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        Integer i = s.nextInt();
        Double d = s.nextDouble();
        System.out.println(str + ", " + i + ", " + d);
    }
}
