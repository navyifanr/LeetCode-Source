//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //哈希法：优化版
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        int l = 0, r = 0, len = str.length();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            //分割单词
            while (r < len && str.charAt(r) == ' ') r++; //去掉单词前面的空格
            l = r;
            while (r < len && str.charAt(r) != ' ') r++;
            String word = str.substring(l, r);
            if (word.isEmpty()) {
                return false;
            }
            if (map.containsKey(ch)) {
                if (!word.equals(map.get(ch))) {
                    return false;
                }
            } else {
                if (map.containsValue(word)) {  //直接判断 values 是否包含当前单词 或者可以用 hashSet 判断，可以减少查找的时间复杂度
                    return false;
                }
                map.put(ch, word);
            }
        }
        while (r < len) {
            if (str.charAt(r) != ' ') {
                return false;
            }
            r++;
        }
        return true;
    }

    //哈希法：两个 hash
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        int l = 0, r = 0, len = str.length();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            //分割单词
            while (r < len && str.charAt(r) == ' ') r++; //去掉单词前面的空格
            l = r;
            while (r < len && str.charAt(r) != ' ') r++;
            String word = str.substring(l, r);
            if (word.isEmpty()) {
                return false;
            }
            //通过【字符——字符串】判断
            if (map.containsKey(ch)) {
                if (!word.equals(map.get(ch))) {
                    return false;
                }
            } else {
                map.put(ch, word);
            }
            //通过【字符串——字符】判断
            if (map2.containsKey(word)) {
                if (ch != map2.get(word)) {
                    return false;
                }
            } else {
                map2.put(word, ch);
            }
        }
        while (r < len) {
            if (str.charAt(r) != ' ') {
                return false;
            }
            r++;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
