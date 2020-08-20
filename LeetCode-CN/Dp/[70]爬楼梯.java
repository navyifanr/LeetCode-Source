package Dp;//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //动态规划，时间复杂度 O(n), 空间复杂度 O(1)
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int p = 1, q = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = p + q;
            p = q;
            q = result;
        }
        return result;
    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T2-7.14, 5min
T3-7.29, 5min
T4-20.8.16, 3min
 */