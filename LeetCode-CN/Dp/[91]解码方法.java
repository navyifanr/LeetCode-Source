//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // dp[n] = dp[n - 1] + dp[n - 2]
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0 || s.charAt(0) == '0') { //不能是 0 开头
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < len; i++) {
            int num = Integer.valueOf(s.substring(i - 1, i + 1));
            if (num <= 26 && num >= 10) {      // 注意，前两位如果是 0 开头是不能解码的，01 不是 A
                dp[i + 1] += dp[i - 1];
            }
            if (s.charAt(i) != '0') {
                dp[i + 1] += dp[i];
            }
        }
        return dp[len];
    }

    //dp[n] = dp[n-1]
    //      + dp[n-2]  (后两位在 10-26)
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;   //注意 dp[0] 是 1，不是 0
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            //error
//            if (s.charAt(i - 1) == '0') return 0;
//            dp[i] = dp[i - 1];
//            if (s.charAt(i - 1) <= '6' && s.charAt(i - 2) == '2' || s.charAt(i - 2) == '1') {
//                dp[i] += dp[i - 2];
//            }
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];   //这里不用 +1
            }
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];   //这里不用 +1
            }
        }
        return dp[len];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T2-7.29, >20min
 */