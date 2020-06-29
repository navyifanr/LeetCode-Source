//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, n, "", result);
        return result;
    }

    public static void generate(int left, int right, int n, String s, List<String> list) {
        if (left == n && right == n) {
            list.add(s);
            return;
        }
        if (left < n) {
            generate(left + 1, right, n,s + "(", list);
        }
        if (left > right && right < n) {
            generate(left, right + 1, n, s + ")", list);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
