package baidu;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        int[] deArr = deduplication(arr);
        //System.out.println(Arrays.toString(deArr));
        sortInteger(deArr);
        //System.out.println(Arrays.toString(deArr));
        if (deArr.length >= 3) {
            System.out.println(deArr[2] + "");
        } else {
            System.out.println(-1 + "");
        }

    }
    public static void sortInteger(int[] A) {
        //如果数组为空，或者数组长度为0，则返回
        if (A == null || A.length == 0) {
            return;
        }
        //调用quickSort
        quickSort(A, 0, A.length - 1);
    }

    private static void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        //两个移动的left right指针
        int left = start;
        int right = end;
        //1.pivot 不能为A[start], A[end]，否则容易出现最坏情况
        //get value not index
        int pivot = A[(start + end) / 2];
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
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
    public static int[] deduplication(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }
        int[] result = new int[set.size()];
        int index = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            result[index] = iterator.next();
            index++;
        }
        return result;
    }
}
