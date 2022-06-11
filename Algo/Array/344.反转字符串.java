/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char ch = s[i];
            s[i++] = s[j];
            s[j--] = ch;
        }
    }
}
// @lc code=end

