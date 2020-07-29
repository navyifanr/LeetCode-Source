//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //以第一个字符串为对比基准，注意只是比较前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int index = 0;
        boolean isBreak = false;
        while (true) {
            if (index >= strs[0].length() || isBreak) {
                break;
            }
            char ch = strs[0].charAt(index);
            int i = 1;
            for (; i < strs.length; i++) {
                if (index >= strs[i].length()) {
                    isBreak = true;
                    break;
                }
                if (ch != strs[i].charAt(index)) {
                    return strs[0].substring(0, index);
                }
            }
            if (i == strs.length) {
                index++;
            }
        }
        return strs[0].substring(0, index);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T1-7.25, >15min
 */