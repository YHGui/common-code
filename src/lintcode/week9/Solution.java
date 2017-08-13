package lintcode.week9;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Katsura on 2017/4/8.
 */
public class Solution {
    public int kthLargestElement2(int[] nums, int k) {
        // Write your code here
        Queue<Integer> minHeap = new PriorityQueue<Integer>(3, new Comparator<Integer>(){
            public int compare(Integer left, Integer right) {
                return left - right;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {9,3,2,4,8,10,5,7};
        Solution solution = new Solution();
        System.out.println(solution.kthLargestElement2(arr, 3));
    }
}
