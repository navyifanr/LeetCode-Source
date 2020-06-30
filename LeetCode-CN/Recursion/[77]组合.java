//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法

/*
        result = []
        def backtrack(路径, 选择列表):
        if 满足结束条件:
        result.add(路径)
        return

        for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n;
    int k;

    public void backtrack(int first, LinkedList<Integer> track) {
        if (track.size() == k) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = first; i <= n; i++) {
            track.add(i);
            backtrack(i + 1, track);
            track.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<>());
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
