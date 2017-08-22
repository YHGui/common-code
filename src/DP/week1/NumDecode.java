package DP.week1;


public class NumDecode {
    /*
       * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        //转换为string数组
        char[] strs = s.toCharArray();
        int num = strs.length;
        if (num == 0) {
            return 0;
        }

        int[] f = new int[num + 1];
        //空串是一种解码方式，也就是解码成null
        f[0] = 1;
        for (int i = 1; i <= num; i++) {
            f[i] = 0;
            int t = strs[i - 1] - '0';
            if (t >= 1 && t <= 9) {
                f[i] += f[i - 1];
            }

            if (i >= 2) {
                t = (strs[i - 2] - '0') * 10 + (strs[i - 1] - '0');
                if (t >= 10 && t <= 26) {
                    f[i] += f[i - 2];
                }
            }
        }

        return f[num];
    }
}
