//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 7934 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> window = new HashMap<>();
            int left, right;
            left = right = 0;
            int res = 0;
            while (right < s.length()) {
                char ch = s.charAt(right++);
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                while (window.get(ch) > 1) {  //注意，此处用 while, 并且取的 ch 不用被下面的 cc 覆盖了
                    char cc = s.charAt(left++);
                    window.put(cc, window.getOrDefault(cc, 0) - 1);
                }
                res = Math.max(res, right - left);  //无需加 1，滑动窗口是左闭右开的模式
            }
            return res;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
