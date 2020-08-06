//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //状态方程： f(i) = max{f(i - 1) + ai, ai}
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(dp[i], maxSum);
        }
        return maxSum;
    }

    //优化版
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxSum = Math.max(pre, maxSum);
        }
        //使用一个 pre 就行，无需 cur
//        int pre = nums[0], cur = 0;
//        for (int i = 1; i < nums.length; i++) {
//            cur = Math.max(pre + nums[i], nums[i]);
//            max = Math.max(max, cur);
//            pre = cur;
//        }
        return maxSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T1-7.17, 15min
T2-7.29，15min   注意最终结果不是返回 dp[nums.length - 1]，而是 maxSum
 */