package lintcode.week2;

/**
 * Created by Katsura on 2017/3/18.
 */
public class QuickSelect {
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        //先进行均分，数据规模变小
        if (nums == null) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int left = start;
        int right = end;
        int pivot = nums[(left + right) / 2];

        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        //分成两段之后，求前kth大值时判断左右端
        if (start + k - 1 <= right) {
            return quickSelect(nums, start, right, k);
        }
        if (start + k - 1 >= left) {
            return quickSelect(nums, left, end, k - (left - start));
        }
        //如果左右都不在，只剩中间还有一个数
        return nums[right + 1];
    }
}
