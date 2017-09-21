package lintcode.week1;

public class Main {
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        int result = 0;
        int len = A.length;
        if (A == null || len == 0) {
            return result;
        }
        int left = findFirst(A, target);
        int right = findLast(A, target);
        return right - left + 1;
    }
    private int findFirst(int[] A, int target) {
        int result = 0;
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] > target){
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] == target) {
            result = start;
        }
        if (A[end] == target) {
            result = end;
        }
        return result;
    }
    private int findLast(int[] A, int target) {
        int result = 0;
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] > target){
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[end] == target) {
            result = end;
        }
        if (A[start] == target) {
            result = start;
        }
        return result;
    }
}
