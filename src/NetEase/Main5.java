package NetEase;

import java.util.Scanner;

/**
 * Created by guiyonghui on 2017/8/12.
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] x = new int[num];
        for (int i = 0; i < num; i++) {
            x[i] = sc.nextInt();
        }

        int[] y = new int[num];
        for (int i = 0; i < num; i++) {
            y[i] = sc.nextInt();
        }

        int[] dp = new int[num];
        dp[0] = 0;
        for (int i = 0; i < num; i++) {
            int count = dp[i];
            
        }
    }
}
