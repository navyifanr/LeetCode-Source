//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> result = new ArrayList<>();

    public void backtrack(int[] nums, boolean[] visited, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1])
                break;  //注意，此处是直接跳出整个循环
            visited[i] = true;
            track.add(nums[i]);
            backtrack(nums, visited, track);
            track.removeLast();
            //注意将访问记录重置为 false
            visited[i] = false;
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        backtrack(nums, new boolean[nums.length], new LinkedList<>());
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
