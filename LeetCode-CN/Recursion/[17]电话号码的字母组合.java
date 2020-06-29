//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法


import java.util.ArrayList;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<Character, String> map = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() > 0) {  //注意空字符的情况
            combinate("", digits, result);
        }
        return result;
    }

    private void combinate(String str, String digits, List<String> list) {
        if (digits.length() == 0) {
            list.add(str);
            return;
        } else {
            Character num = digits.charAt(0);
            String letters = map.get(num);
            for (int i = 0; i < letters.length(); i++) {
                combinate(str + letters.charAt(i), digits.substring(1), list);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
