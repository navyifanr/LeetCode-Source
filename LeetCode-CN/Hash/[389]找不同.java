//给定两个字符串 s 和 t，它们只包含小写字母。 
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 
//
// 示例: 
//
// 输入：
//s = "abcd"
//t = "abcde"
//
//输出：
//e
//
//解释：
//'e' 是那个被添加的字母。
// 
// Related Topics 位运算 哈希表


import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //方法 1：哈希法
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch)) {
                return ch;
            } else {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            }
        }
        throw new RuntimeException("no target char");
    }

    //方法 2：位运算法
    public char findTheDifference(String s, String t) {
        char res = 0;      //char 可以直接定义成数字
        int len = s.length();
        for (int i = 0; i < len; i++) {
            res ^= s.charAt(i) ^ t.charAt(i);
        }
        res ^= t.charAt(len);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T1-20.8.15, 5min
 */