//给定一个字符串，逐个翻转字符串中的每个单词。 
//
// 
//
// 示例 1： 
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 说明： 
//
// 
// 无空格字符构成一个单词。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 
//
// 进阶： 
//
// 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。 
// Related Topics 字符串


import java.util.ArrayDeque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //双端队列（存储整个单词）
    public String reverseWords(String s) {
        //先去除左右边空字符（找到非空字符索引）
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') left++;
        while (left <= right && s.charAt(right) == ' ') right--;

        ArrayDeque<String> deque = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        while (left <= right) {
            char ch = s.charAt(left);
            //找到单词分割点，添加单词
            if (word.length() != 0 && ch == ' ') {
                deque.addFirst(word.toString());
                word.setLength(0);
            } else if (ch != ' ') {
                word.append(ch);
            }
            left++;
        }
        deque.addFirst(word.toString());
        return String.join(" ", deque);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
