package NetEase;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] arr = str.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        int sum1 = 0;
        while (start <= end) {
            while (start <= end && arr[start] == 'G') {
                start++;
            }
            while (start <= end && arr[end] == 'B') {
                end--;
            }
            sum1 = sum1 + end - start;
            start++;
            end--;
        }

        start = 0;
        end = arr.length - 1;
        int sum2 = 0;
        while (start <= end) {
            while (start <= end && arr[start] == 'B') {
                start++;
            }
            while (start <= end && arr[end] == 'G') {
                end--;
            }
            sum2 = sum2 + end - start;
            start++;
            end--;
        }

        int max = Math.min(sum1, sum2);
        System.out.println(max);
    }
}
