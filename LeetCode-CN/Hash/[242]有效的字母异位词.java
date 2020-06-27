//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表

import java.util.Arrays;

/**
 * 1. 排序，比较字符串是否相等；时间复杂度 O(n log n); 空间复杂度 O(n)
 * 2. 哈希法：左字符的字母出现 +1，右字符的字母出现 -1，最后判断存储的所有值是否为 0；
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //1. 排序后比较
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
//        return sArr.toString().equals(tArr.toString());  //注意字符数组转字符串的方法
        return Arrays.equals(sArr, tArr);
    }

    //2. 哈希法：hashmap   时间复杂度 O(n), 空间复杂度 O(n)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sch = s.charAt(i);
            if (map.containsKey(sch)) {
                int count = map.get(sch);
                map.put(sch, ++count);
            } else {
                map.put(sch, 1);
            }
            char tch = t.charAt(i);
            if (map.containsKey(tch)) {
                int count = map.get(tch);
                map.put(tch, --count);
            } else {
                map.put(tch, -1);
            }
        }
        for (Integer count : map.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    // 3. 哈希法：使用数组   时间复杂度 O(n), 空间复杂度 O(1)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }
        for (Integer count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
