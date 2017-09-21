package netease2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by guiyonghui on 2017/9/9.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new  int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int number = n / 2;

        for (int i = 0; i < number; i++) {
            
        }
    }

}
