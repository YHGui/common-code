package DP;

/**
 * Created by Katsura on 2017/4/24.
 */
public class LongestCommonSubstring {
    public static void main(String[] args) {
        String A = "acdefhg";
        String B = "shdefg";
        int max = Integer.MIN_VALUE;
        LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
        System.out.println(longestCommonSubstring.longestCommonSubstring(A, B));
    }
    public int longestCommonSubstring(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = 0;
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                max = Math.max(f[i][j], max);
            }
        }
        return max;
    }
}
