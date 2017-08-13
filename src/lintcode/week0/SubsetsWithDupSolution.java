package lintcode.week0;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Katsura on 2017/3/5.
 */
public class SubsetsWithDupSolution {

    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     * 带有重复元素的全部子集，那么我们需要排除掉相同的元素，在排好序之后进行“选代表”
     * 一般选择第一个元素作为代表
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }

        Arrays.sort(nums);

        ArrayList<Integer> subset = new ArrayList<>();
        subsetsHelper(nums, 0, subset, results);
        
        return results;
    }

    private void subsetsHelper(int[] nums, int startIndex,
                               ArrayList<Integer> subset,
                               ArrayList<ArrayList<Integer>> results) {
        //deep copy && add results
        results.add(new ArrayList<>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            //如果在挑选子集元素的时候，当前元素和前一个元素相同，但是元素下标并不是初始下标
            //意味着前一个相同元素在之前的添加过程已经添加过了，应该排除掉，continue即可
            //同时， i - 1需要防止i为0时溢出，也要考虑此种情况
            // 当然也可以将i != startIndex调至前面，使用&&的“短路性质”
            if (i != 0 && nums[i] == nums[i - 1] && i != startIndex) {
                continue;
            }
            subset.add(nums[i]);
            subsetsHelper(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
}
