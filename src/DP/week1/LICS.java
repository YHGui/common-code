package DP.week1;


public class LICS {

    int result = 0;

    private void calc(int[] nums) {
        int num = nums.length;
        int[] f = new int[num];
        for (int i = 0; i < num; i++) {
            f[i] = 1;
            if (i > 0 && nums[i] > nums[i - 1]) {
                f[i] = f[i - 1] + 1;
            }

            if (f[i] > result) {
                result = f[i];
            }
        }
    }

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        calc(nums);
        int i, j, t;
        i = 0;
        j = nums.length - 1;

        while (i < j) {
            t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }

        calc(nums);

        return result;
    }
}
