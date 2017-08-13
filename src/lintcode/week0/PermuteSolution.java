package lintcode.week0;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katsura on 2017/3/6.
 */
public class PermuteSolution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        helper(nums, results, new ArrayList<Integer>());
        return results;
    }
    //递归：接受什么参数，做了什么事，返回什么值
    //接受nums整型数组，生成list，加入到results
    //退出条件：等到list的长度和原数组的长度一致
    private static void helper(int[] nums, ArrayList<List<Integer>> results, ArrayList<Integer> list) {

        //退出条件
        if (list.size() == nums.length) {
            results.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            helper(nums, results, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
