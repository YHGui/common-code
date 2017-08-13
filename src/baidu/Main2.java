package baidu;

import java.util.Scanner;

/**
 * Created by Katsura on 2017/4/27.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int k = sc.nextInt();
        int[][] dp = new int[1005][1005];
        for (int i = 1; i <= num; i++) {
            dp[i][0] = 1;
        }
        for (int i = 2; i <= num; i++) {
            for (int j = 1; j <= k ; j++) {
                dp[i][j] = (dp[i - 1][j - 1] * (i - j) + dp[i - 1][j] * (j + 1)) % 2017;
            }
        }
        System.out.println(dp[num][k]);
    }
}
