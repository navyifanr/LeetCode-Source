//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] target = res.get(res.size() - 1);
            if (intervals[i][0] > target[1]) {
                res.add(intervals[i]);
            } else {
                target[1] = Math.max(target[1], intervals[i][1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
