package lintcode.week0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Katsura on 2017/3/6.
 */
public class PermuteWithDupSolution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null) {
            return rst;
        }

        if (nums.length == 0) {
            rst.add(new ArrayList<Integer>());
            return rst;
        }

        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[nums.length];
        for (int i = 0; i < visited.length; i++){
            visited[i] = 0;
        }
        helper(rst, list, visited, nums);
        return rst;
    }

    public static void helper(ArrayList<List<Integer>> rst,
                       ArrayList<Integer> list,
                       int[] visited,
                       int[] nums){
        if (list.size() == nums.length) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if (visited[i] == 1 || (i != 0 && nums[i] == nums[i - 1]
                    && visited[i - 1] == 0)){
                continue;
            }
            visited[i] = 1;
            list.add(nums[i]);
            helper(rst, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }

    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,2,2}));
    }
}
