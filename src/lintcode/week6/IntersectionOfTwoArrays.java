package lintcode.week6;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Katsura on 2017/3/17.
 */
public class IntersectionOfTwoArrays {
    //问题：给定两个数组，计算交集
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        //将数组1的所有数放入hashSet中
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            hashSet.add(nums1[i]);
        }
        //如果hashSet有这个数，resultHash不包含这个数，才放入resultHash中，以此来去重
        HashSet<Integer> resultHash = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (hashSet.contains(nums2[i]) && !resultHash.contains(nums2[i])) {
                resultHash.add(nums2[i]);
            }
        }

        int size = resultHash.size();
        int[] result = new int[size];
        int index = 0;
        for (Integer num : resultHash) {
            result[index++] = num;
        }

        return result;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        int[] temp = new int[nums1.length];
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (index == 0 || temp[index - 1] != nums1[i]) {
                    temp[index++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]){
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[index];
        for (int k = 0; k < index; k++) {
            result[k] = temp[k];
        }
        return result;
    }
    //方法一：先把第一个数组里的数放入hash表中，然后再看第二个表中是否有存在于hash表中
    //时间：O(n+m) 空间O(min(m,n))
    //方法二：把两个数组排好序,然后用merge的过程去获取两个数组相同的值
    //方法三：如果两个数组不均等，一个特别大，一个特别小，这时候可以将特别小的进行排序，然后对特别大的进行二分查找
    public static void main(String[] args) {
        System.out.println((int)Math.log(5));
    }
}
