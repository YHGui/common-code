package swordOffer.Problem8;

public class No8 {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(findMin(arr));
    }

    /**
     *     /
     *    /
     *   /
     *  /
     * /
     *        /
     *       /
     *      /
     * 如上图所示，找出比最后一个值小的第一个数即可，通过二分法
     * @param nums
     * @return
     */
    private static int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int target = nums[end];

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] <= target) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}
