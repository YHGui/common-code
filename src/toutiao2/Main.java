package toutiao2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Katsura on 2017/4/18.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] score = new int[num];
        for (int i = 0; i < num; i++) {
            score[i] = sc.nextInt();
        }

        int count = sc.nextInt();
        int[][] query = new int[count][3];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 3; j++) {
                query[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < count; i++) {
            int target = query[i][2];
            int start = query[i][0] - 1;
            int end = query[i][1];
            int[] subArr = Arrays.copyOfRange(score, start, end);
            Arrays.sort(subArr);
            int number = totalOccurrence(subArr, target);
            System.out.println(number);
        }


    }

    public static int totalOccurrence(int[] A, int target) {
        // Write your code here
        int n = A.length;
        if (n == 0)
            return 0;
        if (A[n-1] < target || A[0] > target)
            return 0;

        int l = 0, r = n - 1;
        int start = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (A[mid] >= target) {
                start = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        if (A[start] != target)
            return 0;

        int end = n-1;
        l = 0; r = n-1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (A[mid] <= target) {
                end = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return end - start + 1;
    }
}