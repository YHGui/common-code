package learning01;

/**
 * Created by Katsura on 2017/2/17.
 */
public class Fibonacci {

    public int[] createFib(int maxNum) {
        if (maxNum == 1) {
            return new int[]{1};
        }

        if (maxNum == 2) {
            return new int[]{1, 1};
        }

        int[] num = new int[maxNum];
        num[0] = 1;
        num[1] = 1;

        int index;

        for (index = 2; num[index - 1] + num[index - 2] < maxNum; index++) {
            num[index] = num[index - 1] + num[index - 2];
        }

        int[] result = new int[index];
        System.arraycopy(num, 0, result, 0, index);

        return result;
    }
}
