import java.util.*;

/*
给定一个长度为n的数组nums，请你找到峰值并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个所在位置即可。
1.峰值元素是指其值严格大于左右相邻值的元素。严格大于即不能有等于
2.假设 nums[-1] = nums[n] = -\infty−∞
3.对于所有有效的 i 都有 nums[i] != nums[i + 1]
4.你可以使用O(logN)的时间复杂度实现此问题吗？

数据范围：
1 \le nums.length \le 2\times 10^5 \1≤nums.length≤2×10 
5
  
-2^{31}<= nums[i] <= 2^{31} - 1−2 
31
 <=nums[i]<=2 
31
 −1

如输入[2,4,1,2,7,8,4]时，会形成两个山峰，一个是索引为1，峰值为4的山峰，另一个是索引为5，峰值为8的山峰，如下图所示：

示例1
输入：
[2,4,1,2,7,8,4]
返回值：
1

说明：
4和8都是峰值元素，返回4的索引1或者8的索引5都可以     
示例2
输入：
[1,2,3,1]

返回值：
2

说明：
3 是峰值元素，返回其索引 2     
*/

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组 
     * @return int整型
     */
    public int findPeakElement (int[] nums) {
        // write code here
        int l = 0, r = nums.length - 1;
        while (l < r) {  //注意，不要等于，有可能无法跳出循环
            int mid = (l + r) / 2;  // 不用加一
            if (nums[mid] > nums[mid + 1]) {
                r = mid;  //无需减一
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}