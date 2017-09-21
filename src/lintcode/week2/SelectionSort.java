package lintcode.week2;

import java.util.Arrays;

public class SelectionSort {
    public static void selectSort(int[] nums) {

        //选择排序，时间复杂度为O(n^2),性能略优于冒泡排序，是稳定的排序算法
        //求得最小值的下标lowIndex
        for (int i = 0; i < nums.length; i++) {
            int lowIndex = i;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[lowIndex]) {
                    lowIndex = j;
                }
            }

            //将最小值和当前未排序的起始位置交换，即选出最小的数放在已排序的末尾
            swap(nums, i, lowIndex);
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{9, 2, 5, 8, 1};
        System.out.println(Arrays.toString(testArray));
        selectSort(testArray);
        System.out.println(Arrays.toString(testArray));
    }
}
