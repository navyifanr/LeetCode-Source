//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 示例 1: 
//
// 
//输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc" 
// 
//
// 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int i = 0, j = 0;
        for (; i < str.length && j < str.length;) {
            while (i < str.length && str[i] == ' ') {
                i++;
                j++;
            }
            while (j < str.length && str[j] != ' ') {
                j++;
            }
            if (i < str.length) {
                reverseChars(str, i, j - 1);
            }
            i = j;
        }
        return String.valueOf(str);
    }

    public void reverseChars(char[] str, int i, int j) {
        while (i < j) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            i++;
            j--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
