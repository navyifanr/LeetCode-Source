//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法


import java.util.ArrayList;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.add(nums[i]);
            backtrack(i + 1, nums, list, result);
        }
        return result;
    }

    public void backtrack(int frist, int[] nums, LinkedList<Integer> track, List<List<Integer>> list) {
        list.add(new ArrayList<>(track));
        if (frist == nums.length) {
            return;
        }
        for (int i = frist; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(i + 1, nums, track, list);
            track.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
