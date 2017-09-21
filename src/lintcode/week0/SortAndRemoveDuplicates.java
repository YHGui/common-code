package lintcode.week0;


import java.util.Arrays;

public class SortAndRemoveDuplicates {
    public static int[] sortAndRemoveDuplicates(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }

        int[] newCandidates = new int[index + 1];
        for (int j = 0; j <= index; j++) {
            newCandidates[j] = nums[j];
        }

        return newCandidates;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 4, 5};
        int[] newNums = sortAndRemoveDuplicates(nums);
    }
}
