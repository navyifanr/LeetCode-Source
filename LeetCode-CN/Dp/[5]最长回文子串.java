//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    1. j - i == 0, 1
    dp[i][i] == true      dp[i][j] = (s[i] == s[i+1])
    2. j - i > 1
    dp[i][j] = dp[i+1][j-1] && (s[i] == s[j])

    注意状态方程转移方向，应该有字符串较短到较长的方向转移
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        String res = "";
        for (int l = 0; l < len; l++) { //  l 就是 i,j 距离，这样能保证先遍历字符串较短的字符
            for (int i = 0; i + l < len; i++) {  //注意 i+l, 也就是 j 要小于 len
                int j = l + i;
                if (i == j) { // l == 0
                    dp[i][j] = true;
                } else if (j - i == 1) {   // l == 1
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
                if (dp[i][j] && res.length() < j - i + 1) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }



    //error
//    public String longestPalindrome(String s) {
//        int len = s.length();
//        if (len <= 1) {
//            return s;
//        }
//        boolean[][] dp = new boolean[len][len];
//        String res = "";
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < len; j++) {   //注意状态方程转移方向，应该有字符串较短到较长的方向转移
//                if (i > j) {
//                    continue;
//                }
//                if (j - i == 0) {
//                    dp[i][j] = true;
//                } else if (j - i == 1) {
//                    dp[i][j] = s.charAt(i) == s.charAt(j);
//                } else {
//                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
//                }
//                if (dp[i][j] && res.length() < j - i + 1) {
//                    res = s.substring(i, j + 1);
//                }
//            }
//        }
//        return res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


/*
T1-8.4, > 30min
 */