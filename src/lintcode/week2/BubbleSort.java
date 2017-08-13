package lintcode.week2;

import java.util.Arrays;

/**
 * Created by Katsura on 2017/3/20.
 */
public class BubbleSort {
    //时间复杂度为O(n^2)，冒泡排序是稳定的，最好的时间复杂度为O(n)
    //每次比较相邻的元素，如果第一个比第二个大，就交换他们两个
    //对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，做完后，最后元素会是最大的数，整体上，小数会向前冒出来
    //重复以上步骤，除了最后一个数
    //持续每次对越来越少的元素重复上面步骤，直到没有任何一对数字需要比较
    public static void bubbleSort(int[] nums) {
        int length = nums.length;
        //0~length-1
        for (int i = 0; i < length; i++) {
            //j为0～倒数第二个没有排序的数
            for (int j = 0; j < length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    //定义一个flag来优化冒泡排序方法，当某次比较过程中没有发生任何交换则表明已经排序结束
    public static void bubbleSort2(int[] nums) {
        int length = nums.length;
        boolean flag = true;
        for (int i = 0; i < length; i++) {
            if (flag) {
                for (int j = 0; j < length - i - 1; j++) {
                    flag = false;
                    if (nums[j] > nums[j + 1]) {
                        swap(nums, j, j + 1);
                        flag = true;
                    }
                }
            }
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
        bubbleSort2(testArray);
        System.out.println(Arrays.toString(testArray));
    }
}
