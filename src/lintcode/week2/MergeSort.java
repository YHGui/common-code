package lintcode.week2;

import java.util.Arrays;

/**
 * Created by Katsura on 2017/3/17.
 */
public class MergeSort {
    public static void sortInteger2(int[] A) {
        //数组为空或者数组长度为0则退出
        if (A == null || A.length == 0) {
            return;
        }
        int[] temp = new int[A.length];
        //如果在方法中new出一个数组，不太划算，因此将额外的数组作为参数传进
        mergeSort(A, 0, A.length - 1, temp);
    }
    //先局部有序再整体有序，即先局部排序之后再merge起来，
    // 需要一个额外的空间来merge，开辟新的额外空间需要更多时间(虽然quickSort不是严格的n*logn,略慢于mergeSort，
    // 但是实际却还是quickSort快)
    private static void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        //不管如何，首先从中间切两半，分别对两边进行mergeSort
        mergeSort(A, start, (start + end) / 2, temp);
        mergeSort(A, (start + end) / 2 + 1, end, temp);
        //最后merge起来
        merge(A, start, end, temp);
    }
    /*----时间复杂度分析------*/
    //最好和最坏都是O(n*logn),因为mergeSort的的分治思想并不存在变化
    //归并排序不得不耗费O(n)的额外空间
    //排序稳定性：快速排序是不稳定的排序算法。归并排序是稳定的排序算法

    //merge two sort arrays
    private static void merge(int[] A, int start, int end, int[] temp) {
        int mid = (start + end) / 2;
        int leftIndex = start;
        int rightIndex = mid + 1;
        int index = leftIndex;

        //左右两边还有数可以归并
        while (leftIndex <= mid && rightIndex <= end) {
            //左边比较小
            if (A[leftIndex] < A[rightIndex]) {
                temp[index++] = A[leftIndex++];
            } else {
                //右边比较小
                temp[index++] = A[rightIndex++];
            }
        }
        //左边还有数没有归并
        while (leftIndex <= mid) {
            temp[index++] = A[leftIndex++];
        }
        //右边还有数没有归并
        while (rightIndex <= end) {
            temp[index++] = A[rightIndex++];
        }
        //temp数组里面的数从start开始放入原数组
        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
    }

    //merge数组通常时间复杂度O(n+m)
    public static int[] mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        int[] result = new int[index + 1];
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                result[index--] = A[i--];
            } else {
                result[index--] = B[j--];
            }
        }
        while (i >= 0) {
            result[index--] = A[i--];
        }
        while (j >= 0) {
            result[index--] = B[j--];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] testArray1 = new int[]{1, 2, 3, 5, 7};
        int[] testArray2 = new int[]{8, 9};
        int[] result = mergeSortedArray(testArray1, 5, testArray2, 2);
        System.out.println(Arrays.toString(result));
    }
}
