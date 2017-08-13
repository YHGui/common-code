package lintcode.week0;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Katsura on 2017/3/5.
 */
public class SubsetsSolution {
    //搜索问题的复杂度
    //O(答案个数 × 构造每个答案的时间) 可以用s代替获取每个答案的时间，然后再详细得出来
    //全排列O(N! * N) 全子集(2^N * N)
    //以大化小的recursion的思路
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    //对外接口 interface
    //[1, 2] -> [[], [1], [2], [1, 2]]
    public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        //找到[]开头的子集，放到results中
        helper(results, new ArrayList<Integer>(), nums, 0);

        return results;

    }
    //递归三要素
    //1.递归定义（接受什么参数，返回什么值，做了什么事）
    //找到所有已subset开头的子集都丢到results里
    private static void  helper(ArrayList<ArrayList<Integer>> results,
                        ArrayList<Integer> subset,
                        int[] nums,
                        int startIndex) {
    //2.递归的拆解, deep copy，若只是results.add(subset)只是复制了旧的引用
        results.add(new ArrayList<>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]); //[] -> [1]
            helper(results, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
        //自然而然return
        //3.递归的出口（什么时候不往下递归了，可以直接找到答案退出）
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
