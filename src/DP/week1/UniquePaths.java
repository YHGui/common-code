package DP.week1;

public class UniquePaths {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] sum = new int[m][n];
        //每一列的位置都只有一种方式
        for (int i = 0; i < m; i++) {
            sum[i][0] = 1;
        }
        //每一行的位置都只有一种方式
        for (int i = 0; i < n; i++) {
            sum[0][i] = 1;
        }
        //分别对应加上右和下的情况
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
            }
        }
        return sum[m - 1][n - 1];
    }
}
