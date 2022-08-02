//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 2038 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int[] window = new int[64];
        int[] need = new int[64];
        int total = 0;
        for (int i = 0; i < t.length(); i++) {
            char cc = t.charAt(i);
            need[cc - 'A']++;
            if (need[cc - 'A'] == 1) {
                total++;
            }
        }
        int left, right, vaild;
        left = right = vaild = 0;
        int start, end;  //记录起始索引
        start = 0;
        end = Integer.MAX_VALUE;
        while (right < s.length()) {
            char ch = s.charAt(right++);
            if (need[ch - 'A'] > 0) {
                window[ch - 'A']++;
                if (need[ch - 'A'] == window[ch - 'A']) {
                    vaild++;
                }
            }
            //只有有效数达标，才收缩左边窗口
            while (vaild == total) {
                if (right - left < end - start) {
                    start = left;
                    end = right;
                }
                char ca = s.charAt(left++);
                if (need[ca - 'A'] > 0) {
                    if (window[ca - 'A'] == need[ca - 'A']) {
                        vaild--;
                    }
                    window[ca - 'A']--;
                }
            }
        }
        return end == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
