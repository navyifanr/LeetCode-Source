//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
// 
//
// 若这两个字符串没有公共子序列，则返回 0。 
//
// 
//
// 示例 1: 
//
// 输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace"，它的长度为 3。
// 
//
// 示例 2: 
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
// 
//
// 示例 3: 
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// 输入的字符串只含有小写英文字符。 
// 
// Related Topics 动态规划


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        int[][] dp = new int[len1 + 1][len2 + 1];  // 加 1，更方便处理边界情况
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {  //注意，要减一，索引从 1 开始
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    // error , 误区：1. 边界的计算； 2. 字符相等时，已那个基准加一？ 3. 字符不等时，取左边还是上面（两者最大还是最小值）？
//    public int longestCommonSubsequence(String text1, String text2) {
//        int len1 = text1.length();
//        int len2 = text2.length();
//        if (len1 == 0 || len2 == 0) {
//            return 0;
//        }
//        int[][] dp = new int[len1][len2];
//        Arrays.fill(dp[0], 1);
//        for (int i = 0; i < len1; i++) {
//            for (int j = 0; j < len2; j++) {
//                //第一行
//                if (i == 0) {
//                    if (text1.charAt(0) == text2.charAt(j)) {
//                        break;
//                    }
//                    dp[0][j] = 0;
//                    continue;
//                }
//                //第一纵列
//                if (j == 0) {
//                    if (text1.charAt(i) == text2.charAt(0)) {
//                        dp[i][0] = 1;
//                    } else {
//                        dp[i][0] = dp[i - 1][0];
//                    }
//                    continue;
//                }
//
//                if (text1.charAt(i) == text2.charAt(j)) {
//                    dp[i][j] = dp[i - 1][j] + 1;
//                } else {
//                    if (j - 1 >= 0) {
//                        dp[i][j] = Math.max(dp[i - 1][j], dp[i, j - 1])
//                    } else {
//                        dp[i][j] = dp[i - 1][j];
//                    }
//                }
//            }
//        }
//        return dp[len1 - 1][len2 - 1];
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T1-7.14, >1h
 */