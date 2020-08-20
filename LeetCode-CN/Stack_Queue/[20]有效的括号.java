//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //2. 代码优化版
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.add(ch);
            } else {
                if (!stack.isEmpty() && isMatch(stack.peek(), ch)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isMatch(char ch1, char ch2) {
        return (ch1 == '(' && ch2 == ')')
                || (ch1 == '[' && ch2 == ']')
                || (ch1 == '{' && ch2 == '}');
    }

    //方法1.
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                if (ch == ')' || ch == ']' || ch == '}') {
                    return false;
                } else {
                    stack.add(ch);
                }
            } else {
                if (ch == '(' || ch == '[' || ch == '{') {
                    stack.add(ch);
                } else {
                    char tmp = stack.peek();
                    if (tmp == rightToLeft(ch)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public char rightToLeft(char ch) {
        if (ch == ')') {
            return '(';
        } else if (ch == ']') {
            return '[';
        } else {
            return '{';
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T3-20.8.14, 11min
 */