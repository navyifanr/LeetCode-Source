//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划


import java.util.Arrays;
import java.util.Collections;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {  //amount == 0 时，返回 0
            return -1;
        }
        Arrays.sort(coins);
        int[] memo = new int[amount + 1];
        return dp(coins, amount, memo);
    }

    public int dp(int[] coins, int amount, int[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        //注意，避免索引越界
        if (memo[amount] != 0) {
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            int count = dp(coins, amount - coins[i], memo);
            if (count == -1) continue;
            min = Math.min(min, count + 1);
        }
        memo[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T1-7.1, >1h, 动态规划-暴力法，超时
             动态规划-备忘录，AC
 */