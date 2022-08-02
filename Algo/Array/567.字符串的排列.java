//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 733 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] window = new int[26];
        int[] need = new int[26];
        int total = 0;
        for (int i = 0; i < s1.length(); i++) {
            char cc = s1.charAt(i);
            need[cc - 'a']++;
            if (need[cc - 'a'] == 1) {
                total++;
            }
        }
        int left, right, valid;
        left = right = valid = 0;
        while (right < s2.length()) {
            char ch = s2.charAt(right++);
            if (need[ch - 'a'] > 0) {
                window[ch - 'a']++;
                if (window[ch - 'a'] == need[ch - 'a']) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == total) {
                    return true;
                }
                ch = s2.charAt(left++);
                if (need[ch - 'a'] > 0) {
                    if (window[ch - 'a'] == need[ch - 'a']) {
                        valid--;
                    }
                    window[ch - 'a']--;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
