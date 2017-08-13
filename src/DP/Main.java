package DP;

/**
 * Created by Katsura on 2017/4/18.
 */
public class Main {
    public static void main(String[] args) {
        int[] f = new int[28];
        f[0] = 0;
        for (int i = 1; i < 28; i++) {
            f[i] = Integer.MAX_VALUE;
            //三种类型(2,5,7)的硬币，求最少的数量拼出27
            if (i - 2 >= 0 && f[i - 2] < Integer.MAX_VALUE && f[i - 2] + 1 < f[i]) {
                f[i] = f[i - 2] + 1;
            }
            if (i - 5 >= 0 && f[i - 5] < Integer.MAX_VALUE && f[i - 5] + 1 < f[i]) {
                f[i] = f[i - 5] + 1;
            }
            if (i - 7 >= 0 && f[i - 7] < Integer.MAX_VALUE && f[i - 7] + 1 < f[i]) {
                f[i] = f[i - 7] + 1;
            }
        }
        System.out.print(f[27]);
    }
    //f[x]表示最少用多少枚硬币拼出x，一共有三中硬币
    //初始条件、边界条件、转移方程
    //首先看最后一步，然后化成子问题，然后由转移方程和初始条件+边界情况，考虑计算顺序
    //动态规划的组成部分1：转移方程
    //组成部分2：初始条件+边界情况
    //组成部分3：计算顺序
}
