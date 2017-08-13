package elem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Katsura on 2017/5/25.
 */
public class Main1 {
    /**
     * 2.	设计一个函数, 求三个增序排列数组的最大共同元素。
     * 通过三个指针来表示三个递增数组的，做线性搜索，直至遇到相同的元素，时间复杂度为最坏情况下3×min(len1, len2, len3)
     * 整体来说，如果将数组分别按从大到小排序，那么实际情况下，时间复杂整体会改善，但是最坏还是不变的。
     * 想到的另一种方法是一次扫描两个数组，找出相同元素，然后通过二分法找是否存在于第三个数组，可以将最短长度数组包含于扫描的两个数组
     * 之一，另一个作为搜索数组，那么时间复杂度为min(len1, len2) * log(len3),时间关系，就不写两种情况，测试用例也没有写很多。
     * @param arr1
     * @param arr2
     * @param arr3
     * @return
     */
    public int findLargestCommonElement(int[] arr1, int[] arr2, int[] arr3) {
        //极端情况
        if (arr1 == null || arr2 == null || arr3 == null ||
                arr1.length == 0 || arr2.length == 0 || arr3.length == 0) {
            return -1;
        }
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len3 = arr3.length;
        int result = Integer.MIN_VALUE;
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        while (index1 < len1 && index2 < len2 && index3 < len3) {
            if (arr1[index1] < arr2[index2]) {
                index1++;
            } else if (arr2[index2] < arr3[index3]){
                index2++;
            } else if (arr3[index3] < arr1[index1]) {
                index3++;
            } else {
                if (arr1[index1] > result) {
                    result = arr1[index1];
                }
                index1++;
                index2++;
                index3++;
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] arr1 = {1, 2, 4, 8, 9};
        int[] arr2 = {2, 3, 7, 8, 10};
        int[] arr3 = {3, 5, 7, 8};
        assertEquals(8, findLargestCommonElement(arr1, arr2, arr3));
    }
}
