package NetEase;

import java.util.Scanner;

/**
 * Created by guiyonghui on 2017/8/12.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int f = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();
        int maxDay = d / x;
        int day = 0;
        if (f > maxDay) {
            day = maxDay;
        } else {
            int otherDay = (d - f * x) / (p + x);
            day = otherDay + f;
        }

        System.out.println(day);
    }
}
