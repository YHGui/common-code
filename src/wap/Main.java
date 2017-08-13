package wap;

/**
 * Created by Katsura on 2017/5/19.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println(solve(n, k));
    }

    public static int solve(int n, int k) {
        int[][] dp = new int[2][k + 1];
        dp[0][0] = dp[1][0] = 1;
        int row = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[row][j] = 0;
                for (int l = 0; l < i && l <= j; l++) {
                    dp[row][j] += dp[row^1][j - 1];
                }
            }
            row ^= 1;
        }
        return dp[row^1][k];
    }
}
