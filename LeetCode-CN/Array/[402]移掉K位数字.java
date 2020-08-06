//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。 
//
// 注意: 
//
// 
// num 的长度小于 10002 且 ≥ k。 
// num 不会包含任何前导零。 
// 
//
// 示例 1 : 
//
// 
//输入: num = "1432219", k = 3
//输出: "1219"
//解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
// 
//
// 示例 2 : 
//
// 
//输入: num = "10200", k = 1
//输出: "200"
//解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 : 
//
// 
//输入: num = "10", k = 2
//输出: "0"
//解释: 从原数字移除所有的数字，剩余为空就是0。
// 
// Related Topics 栈 贪心算法


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        int keep = n - k;
        //error
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < n; i++) {
//            char ch = num.charAt(i);
//            while (k > 0 && !stack.isEmpty() && stack.peek() > ch) {
//                stack.pop();
//                k--;
//            }
//            stack.add(ch);
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < keep; i++) {
//            sb.append(stack.pop());
//        }
//        //注意要翻转，并且去除头部的 0
//        String res = sb.reverse().toString().replaceFirst("^0*", "");
//        return res.isEmpty() ? "0" : res;

        LinkedList<Character> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            while (k > 0 && !queue.isEmpty() && queue.peekLast() > ch) {
                queue.pollLast();
                k--;
            }
            queue.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keep; i++) {
            char ch = queue.pollFirst();
            if (sb.length() != 0 || ch != '0') {
                sb.append(ch);
            }
        }
        String res = sb.toString();
        return res.isEmpty() ? "0" : res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T1-7.30, >1h
 */