//我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学

/**
 * 1. 暴力法：（略）逐数递增，判断该数是丑数，计数加 1
 * 2. 动态规划：时间复杂度 O(n), 空间复杂度 O(n)
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int nthUglyNumber(int n) {
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int v2 = dp[i2] * 2, v3 = dp[i3] * 3, v5 = dp[i5] * 5;
            dp[i] = Math.min(Math.min(v2, v3), v5);
            if (dp[i] == v2) i2++;
            if (dp[i] == v3) i3++;
            if (dp[i] == v5) i5++;
        }
        return dp[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
