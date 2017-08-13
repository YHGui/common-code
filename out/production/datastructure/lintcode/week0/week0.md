#Coding Style
>最容易出卖你的，就是你的coding style，工程师的代码长什么样比脸长什么样重要。

面试官眼中的求职者：
- 你可能是他未来的同事！！！
- 你的代码看起来舒服么，需要多少时间来Review你的代码
- 你的coding习惯好么，会不会动不动搞挂网站，造成损失
- 交流是否舒服，**沟通能力**

基本功：
- coding style：变量命名，缩进，括号
- coding 习惯，bug free，是否进行异常检测，边界处理
- 沟通交流
- 测试：主动给出test case，cover掉所有情况
###subset模板
```java
public class SubsetsSolution{
    public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
            ArrayList<ArrayList<Integer>> results = new ArrayList<>();
    
            if (nums == null || nums.length == 0) {
                return results;
            }
            //首先排序
            Arrays.sort(nums);
            //找到[]开头的子集，放到results中
            helper(results, new ArrayList<Integer>(), nums, 0);
    
            return results;
    
        }
    //递归三要素
        //1.递归定义（接受什么参数，返回什么值，做了什么事）
        //找到所有已subset开头的子集都丢到results里
        private static void helper(ArrayList<ArrayList<Integer>> results,
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
}
```
###Permute模板
```java
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

        //退出条件,没有重复元素
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
}
```