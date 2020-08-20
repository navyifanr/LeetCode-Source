//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //状态方程： f(i)max = max{f(i - 1)max * ai, ai, f(i - 1)min * ai};
    //         f(i)min = min{f(i - 1)min * ai, ai, f(i - 1)max * ai};
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(Math.max(dp[i - 1] * nums[i], nums[i]), min[i - 1] * nums[i]);
            min[i] = Math.min(Math.min(min[i - 1] * nums[i], nums[i]), dp[i - 1] * nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T1-7.17, >20min
T2-20.8.18, >30min  注意最小值的 dp 方程
 */
