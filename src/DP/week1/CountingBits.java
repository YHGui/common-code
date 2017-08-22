package DP.week1;


public class CountingBits {

    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        f[0] = 0;
        for (int i = 0; i <= num; i++) {
            f[i] = f[i >> 1] + (i % 2);
        }

        return f;
    }
}
