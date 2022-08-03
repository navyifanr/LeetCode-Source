import java.util.List;
import java.util.Map;

//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 962 👎 0


// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] window = new int[26];
        int[] need = new int[26];
        int total = 0;
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            need[ch - 'a']++;
            if (need[ch - 'a'] == 1) {
                total++;
            }
        }
        int left = 0, right = 0;
        List<Integer> res = new ArrayList<>();
        int valid = 0;
        while (right < s.length()) {
            char ch = s.charAt(right++);
            if (need[ch - 'a'] > 0) {
                window[ch - 'a']++;
                if (window[ch - 'a'] == need[ch - 'a']) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == total) {
                    res.add(left);
                }
                ch = s.charAt(left++);
                if (need[ch - 'a'] > 0) {
                    if (need[ch - 'a'] == window[ch - 'a']) {
                        valid--;
                    }
                    window[ch - 'a']--;
                }
            }
        }
        return res;
    }
}
// @lc code=end

