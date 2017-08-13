package lintcode.week2;

/**
 * Created by Katsura on 2017/3/20.
 */
public class CountSort {
    public static int[] countSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }
        //找一个helper数组，空间为max
        int[] helper = new int[max];
        //值为arr[i] - min处，则该下标处值+1，属于计数阶段
        for (int i = 0; i < arr.length; i++) {
            int mapPos = arr[i] - min;
            helper[mapPos]++;
        }

        int index = 0;
        //计数数组的每一个非零值
        for (int i = 0; i < helper.length; i++) {
            while (helper[i]-- > 0) {
                arr[index++] = i + min;
            }
        }

        return arr;
    }
}
