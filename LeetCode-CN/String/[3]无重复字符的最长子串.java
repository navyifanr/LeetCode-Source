//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
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
// Related Topics 哈希表 双指针 字符串 Sliding Window


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 方法 2：遍历每个字符都判断 max
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (map.containsKey(ch)) {
                l = Math.max(l, map.get(ch) + 1);
            }
            map.put(ch, r);
            max = Math.max(max, r - l + 1);   //遍历每个字符都判断 max
            r++;
        }
        return max;
    }

    //方法 1
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0; //
        int l = 0, r = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (map.containsKey(ch) && map.get(ch) >= l) {  // map包含该节点，并且要在滑动窗口内；也就是包含的节点索引要不小于窗口左边
                max = Math.max(max, r - l);
                l = map.get(ch) + 1;
            }
            map.put(ch, r);
            r++;
        }
        max = Math.max(max, r - l);  //注意，不要漏了最后一个比较
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T2-20.8.15, >15min
 */