package toutiao;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Katsura on 2017/4/18.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int[] arr1 = new int[number1];
        for (int i = 0; i < number1; i++) {
            arr1[i] = sc.nextInt();
        }
        int number2 = sc.nextInt();
        int[] arr2 = new int[number2];
        for (int i = 0; i < number2; i++) {
            arr2[i] = sc.nextInt();
        }
        int[] arr2copy = new int[number2];
        for (int i = 0; i < number2; i++) {
            arr2copy[i] = arr2[i];
        }
        int[] result = intersection(arr1, arr2);
        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (count == result.length) {
                break;
            }
            for (int j = 0; j < result.length; j++) {
                if (arr2[i] == result[j]) {
                    System.out.print(arr2[i] + " ");
                    count++;
                }
            }
        }

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            hash.add(nums1[i]);
        }

        HashSet<Integer> resultHash = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (hash.contains(nums2[i]) && !resultHash.contains(nums2[i])) {
                resultHash.add(nums2[i]);
            }
        }

        int size = resultHash.size();
        int[] result = new int[size];
        int index = 0;
        for (Integer num : resultHash) {
            for (int i = 0; i < nums2.length; i++) {
                if (nums2[i] == num) {
                    result[index++] = num;
                }
            }
        }

        return result;
    }
}
