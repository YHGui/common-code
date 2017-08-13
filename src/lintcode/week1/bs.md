#Binary Search
###核心
将binary search的问题转化为：寻找第一个或者最后一个，该target元素出现的位置问题。

Find the any/first/last position of target in nums

###四要素
```java
1. start + 1 < end
```
当指针指到两个元素，相邻或者相交的时候，循环停止。这样的话最终分情况讨论的时候，只要考虑1~2个元素
```java
2. start + (end - start) / 2
```
考虑到int的overflow的问题，所以需要考虑边界情况。
```java
3. A[mid] ==, >, < 
```
在循环中，分三种情况讨论边界。要注意，在移动start和end的时候，只要单纯的把指针指向mid位置，不要+1或者-1。因为只移动边界到mid的位置，
不会误删target。在工程中，尽量在程序的最后统一写return，增强可读性。
```java
4. A[start],A[end]?target
```
在循环结束时，因为只有1或者2个元素需要讨论，结果非常容易解释。只存在的2种情况为： 
```java
start + 1 == end
``` 
边界指向相邻的两个元素， 这时只需要分情况讨论start和end与target的关系，就可以得出结果。 
```java
start == end 
```
边界指向同一元素， 其实这个情况还是可以按照1的方法，分成start end讨论，只不过讨论结果一样而已。

```java
public class Solution {
    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return  -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        
        return -1;
    }
}
```
###问题扩充
**_二分位置_**

寻找target最后一次出现的位置：

上述四要素中，A[mid] == target时，让start = mid，target出现的位置在mid至end的位置。
因此最后循环结束也是先判断end的位置，然后才判断start的位置。

寻找target第一次出现的位置：

同理，四要素中，A[mid] == target时，让end = mid，target出现的位置在start至mid的位置。
因此最后循环结束也是先判断start的位置，然后才判断end的位置。

如果需要寻找出所有的target位置，以数组的形式返回数组包括首尾的两个下标，则结合上述两步，综合得到数组。