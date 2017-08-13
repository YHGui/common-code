package lintcode.week9;

/**
 * Created by Katsura on 2017/4/9.
 */
public class DP {
    //记忆化搜索
    public int minimumTotal(int[][] triangle) {
        int len = triangle.length;
        int[][] hash = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                hash[i][j] = Integer.MAX_VALUE;
            }
        }
        return divideConquer(triangle, hash, 0, 0);
    }
    //每个点访问两次，有n^2个点
    private int divideConquer(int[][] triangle, int[][] hash, int x, int y) {
        if (x == triangle.length) {
            return 0;
        }
        if (hash[x][y] != Integer.MAX_VALUE) {
            return hash[x][y];
        }
        int left = divideConquer(triangle, hash, x + 1, y);
        int right = divideConquer(triangle, hash, x + 1, y + 1);
        hash[x][y] = Math.min(left, right) + triangle[x][y];
        return hash[x][y];
    }

    public static void main(String[] args) {
        DP dp = new DP();
        int[][] arr = {{2},{3,4},{6,5,7},{4,1,8,3}};
        System.out.println(dp.minimumTotal(arr));
        System.out.println(dp.minimumTotal2(arr));
    }
    public int minimumTotal2(int[][] triangle) {
        int length = triangle.length;
        int[][] f = new int[length][length];
        f[0][0] = triangle[0][0];
        //初始化最左边和最右边的情况
        for (int i = 1; i < length; i++) {
            f[i][0] = f[i - 1][0] + triangle[i][0];
            f[i][i] = f[i - 1][i - 1] + triangle[i][i];
        }
        //方程计算
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + triangle[i][j];
            }
        }
        //求解答案
        int best = f[length - 1][0];
        for (int i = 0; i < length; i++) {
            best = Math.min(best, f[length - 1][i]);
        }
        return best;
    }
}
