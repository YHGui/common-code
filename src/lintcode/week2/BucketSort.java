package lintcode.week2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Katsura on 2017/3/20.
 */
public class BucketSort {
    //假设数组元素最大值和最小值分别为max和min，则桶的个数为max - min + 1，
    // 也即数组区间[min, max]每个元素和桶下标区间[0,max - min + 1]中每个元素一一对应，这也是桶排序的核心思想。
    //非比较排序时间复杂度都是O(n)，遍历一次即可
    public static void bucketSort(int[] arr) {

        //假定：输入是一个随机过程产生的[0, 1)区间上均匀分布的实数，将区间划分为n个大小相等的子区间(桶)
        //每个桶的大小为[0, 1/n), [1/n, 2/n),[2/n, 3/n),...[k/n, (k+1)/n),...
        //将n个输入元素分配到这些桶中，对桶中元素进行排序，然后依次连接桶输入0<=A[1..n]<1
        //适用于已知区间，时间复杂度为O(n)的排序.
        //桶排序是稳定的

    }

    public static void main(String[] args) {
        int[] testArr = new int[]{9012,68957,39867,19702,83556,102456};
        System.out.println(Arrays.toString(testArr));
        int[] result = asc(testArr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] asc(int[] array, int step) {
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            min = Math.min(min, array[i]);
            max = Math.max(max, array[i]);
        }
        return sort(array, min, max, step);
    }

    public static int[] asc(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            min = Math.min(min, array[i]);
            max = Math.max(max, array[i]);
        }
        int step = (max - min + 1) / 200;
        if (step < 1) {
            step++;
        }
        return sort(array, min, max, step);
    }

    private static int[] sort(int[] array, int min, int max, int step) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        int num = (max - min + 1) /step;
        if (num < 1) {
            num++;
        }
        //每个空桶
        for (int i = min; i <= max ; i = i + step) {
            //每个桶里是一个链表
            List<Integer> bucket = new LinkedList<Integer>();
            list.add(bucket);
        }
        //找到数组中每个值的桶的位置，然后放进去
        for (int i = 0; i < array.length; i++) {
            int index = (array[i] - min) / step;
            list.get(index).add(array[i]);
        }

        // 对每个桶内部排序（可以递归桶排序）
        for( int i = 0 ; i < list.size() ; i++ ){
            list.set(i,insert(list.get(i)));
        }
        // 将排序后的桶放回数组
        int k = 0;
        for( int i = 0 ; i < list.size() ; i++ ){
            List<Integer> temp = list.get(i);
            for( int j = 0 ; j < temp.size() ; j++ ){
                array[k] = (int) temp.get(j);
                k++;
            }
        }
        return array;
    }

    //插入排序
    //插入排序就是将无序表中的所有元素插入有序表中
    //时间复杂度是O(n^2)
    private static List<Integer> insert( List<Integer> list ) {
        for (int i = 1; i < list.size() ; i++) {
            //首先将只有一个元素当作有序表
            int key = list.get(i);
            int j = i - 1;
            while ( j >= 0 && list.get(j) > key ) {
                list.set(j+1,list.get(j));
                j = j - 1;
            }
            list.set(j+1,key);
        }
        return list;
    }
}
