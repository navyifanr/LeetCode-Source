//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> result = new ArrayList<>();

    public void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //注意要排除选择过的
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new LinkedList<>());
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
