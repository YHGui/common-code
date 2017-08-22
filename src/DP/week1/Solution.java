package DP.week1;


public class  Solution {

    public int coinChange(int[] coins, int amount) {
        int coinNum = coins.length;
        int[] f = new int[amount + 1];
        f[0] = 0;
        for (int i = 1;i <= amount; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coinNum; j++) {
                if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE && f[i - coins[j]] + 1 < f[i]) {
                    f[i] = f[i - coins[j]] + 1;
                }
            }
        }

        if (f[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return f[amount];
        }
    }
}

