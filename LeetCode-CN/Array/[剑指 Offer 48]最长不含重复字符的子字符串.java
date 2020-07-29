//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
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
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 双指针 Sliding Window


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //方法 1：哈希 + 双指针
    public int lengthOfLongestSubstring(String s) {
        int maxCount = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = -1;  //注意 左指针 从重复索引的前一个开始
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)));  // 多个不同的重复字母，应该取最大的索引  no : left = i   or   left = map.get(s.charAt(i));
            }
            map.put(s.charAt(i), i);
            maxCount = Math.max(maxCount, i - left);
        }
        return maxCount;
    }

    //方法 2：动态规划
    public int lengthOfLongestSubstring(String s) {
        int maxCount = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);
            count = count < i - index ? count + 1 : i - index;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T1-7.25, >30min
 */
