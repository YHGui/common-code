package DP.week1;

public class PaintHouse {
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // Write your code here
        int n = costs.length;
        if (n == 0) {
            return 0;
        }

        int[][] f = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                f[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (j == k) {
                        continue;
                    }

                    if (f[i - 1][k] + costs[i - 1][j] < f[i][j]) {
                        f[i][j] = f[i - 1][k] + costs[i - 1][j];
                    }
                }
            }
        }

        int result = f[n][0];
        if (f[n][1] < result) {
            result = f[n][1];
        }

        if (f[n][2] < result) {
            result = f[n][2];
        }

        return result;
    }
}
