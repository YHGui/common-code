package learning01;

import java.util.ArrayList;

/**
 * Created by Katsura on 2017/3/20.
 */
public class SingleNumber {
    public static ArrayList<Integer> singleNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ArrayList<Integer> result = new ArrayList<Integer>();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }

        int[] helper = new int[max];

        for (int i = 0; i < arr.length; i++) {
            int mapPos = arr[i] - min;
            helper[mapPos]++;
        }

        int index = 0;
        for (int i = 0; i < helper.length; i++) {
            if (helper[i] == 1) {
                result.add(i + min);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,2,3,5,7};
        int[] arr2 = {2,4,2,7,4,9,7};
        System.out.println(singleNumber(arr1));
        System.out.println(singleNumber(arr2));
    }
}
