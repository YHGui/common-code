package lintcode.week2;

import java.util.Arrays;

/**
 * Created by Katsura on 2017/3/17.
 */
public class QuickSort {
    public static void sortInteger(int[] A) {
        //如果数组为空，或者数组长度为0，则返回
        if (A == null || A.length == 0) {
            return;
        }
        //调用quickSort
        quickSort(A, 0, A.length - 1);
    }

    private static void quickSort(int[] A, int start, int end) {
        //quickSort包含两个指针，start end
        //如果start = end 那么只有一个数，不需要排序，退出
        //如果start > end 这种情况不考虑，异常，退出
        if (start >= end) {
            return;
        }
        //两个移动的left right指针
        int left = start;
        int right = end;
        //1.pivot 不能为A[start], A[end]，否则容易出现最坏情况
        //get value not index
        int pivot = A[(start + end) / 2];
        /*----------partition---------*/
        //2.left <= right not left < right partition
        //为什么呢？会出现stackOverflow
        //比如[3, 2, 1, 4, 5]->[1, 2, 3, 4, 5]此时left和right指针同时位于2，跳出循环while，
        // 随后quickSort(A, start, right)和quickSort(A, left, end),其中重复了left和right
        //因此要left <= right, 最后出现交叉的现象

        //首先left指针运动到不小于pivot停止，而right指针运动到不大于pivot停止
        //不是严格的小于pivot在左边，大于等于pivot的在右边？
        //为了防止大量数相等时，partition不均衡情况，为了partition尽量均等
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            //然后交换left和right值，同时left++，right--；
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        //一次宏观的排序(分成两段，前半段整体小于后半段)
        //然后分别对前后半段进行排序
        /*----时间复杂度分析------*/
        /*T(n) = 2T(n/2) + O(n)
        *两边同时除以n，则T(n)/n = T(n/2) / n/2 + O(1)
        * T(n)/n = O(logn)
        * T(n) = nO(logn)
        * 最坏情况
        * T(n) = T(n-1) + T(1) + O(n),相当于白划分了，每次只划出一个出来，
        * 此时时间复杂度为O(n^2)
        * 平均情况分析
        * T(n) = T(i) + T(n - i - 1) + cn
        * nT(n) = 2 * sum(T(i)) + cn^2 (i=0~n-1)
        * (n - 1)T(n - 1) = 2 * sum(T(i)) + c(n-1)^2 (i=0~n-2)
        * 相减得到T(n) / (n + 1) = T(n - 1) / n + 2c / (n + 1)
        * 可以得到T(n) = nO(logn)
        * */
         /*----空间间复杂度分析------*/
         /*递归调用造成栈空间的使用，由于递归树的深度为logn，空间复杂度也就为O(logn),最坏情况进行n-1递归，为O(n)
         平均情况也为O(logn)
         * */
         /*----稳定性分析------*/
         /*稳定性，是指假设待排序记录中有两个相同的元素，他们排序前后的相对位置是否变化,相对位置不变和则是稳定的
         * quickSort在交换pivot和某个位置的值时，很有可能会把位置更换，因此是不稳定
         * */
        quickSort(A, start, right);
        quickSort(A, left, end);
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{1, 9, 10, 10, 10, 23, 10};
        //如何直接打印出数组，System.out.println(Arrays.toString(testArray));
        //当遇到多维数组的时候，使用Arrays.deepToString()方法
        System.out.println(Arrays.toString(testArray));
        sortInteger(testArray);
        System.out.println(Arrays.toString(testArray));
    }
}
