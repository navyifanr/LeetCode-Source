//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window


import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {  //注意等号
            int[] letters2 = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                letters2[s2.charAt(i + j) - 'a']++;
            }
            if (compareIntArrs(letters, letters2)) {
                return true;
            }
        }
        return false;
    }

    public boolean compareIntArrs(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    //排序，比较字字符串
//    public boolean checkInclusion(String s1, String s2) {
//        if (s2.length() < s1.length()) {
//            return false;
//        }
//        int size = s1.length();
//        HashMap<Character, Integer> map = new HashMap<>();
//        HashMap<Character, Integer> tmpMap;
//        for (char ch : s1.toCharArray()) {
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//        for (int i = 0; i < s2.length() - size; i++) {
//            if (map.containsKey(s2.charAt(i))) {
//                int k = 1;
//                tmpMap = new HashMap<>(map);
//                while (k++ <= size) {
//                    int ch = s2.charAt(i + k);
//                    if (tmpMap.get(ch) <= 0) {
//                        break;
//                    }
//                    if (tmpMap.containsKey(ch)) {
//                        tmpMap.put(ch, tmpMap.get(ch) - 1);
//                    }
//                }
//                if (k == )
//            }
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
