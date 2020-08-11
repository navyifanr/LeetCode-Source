//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表


import java.util.ArrayList;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] data = new int[26];
        int[] window = new int[26];
        int diffSize = 0; //记录 p 中不同字母的数量
        for (char ch : p.toCharArray()) {
            if (data[ch - 'a'] == 0) {
                diffSize++;
            }
            data[ch - 'a']++;
        }
        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            if (data[ch - 'a'] != 0) {
                window[ch - 'a']++;
                if (data[ch - 'a'] == window[ch - 'a']) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (valid == diffSize) { //注意此处是根据不同字母数量判断
                    res.add(left);
                }
                //移动窗口左边
                char cc = s.charAt(left);
                left++;
                if (data[cc - 'a'] != 0) {
                    if (data[cc - 'a'] == window[cc - 'a']) {
                        valid--;
                    }
                    window[cc - 'a']--;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
