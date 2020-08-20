//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //注意：结构可能是  xxxk[]k[]xxx， 也有可能  xxxk[xxk[]xx]
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int k = 0;
        LinkedList<Integer> kStack = new LinkedList<>();
        LinkedList<String> resStack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                k = k * 10 + Integer.parseInt(String.valueOf(ch));
            } else if (ch == '[') {
                kStack.addLast(k);
                resStack.addLast(res.toString());
                k = 0;
                res.setLength(0);
            } else if (ch == ']') {
                StringBuilder tmp = new StringBuilder();
                int count = kStack.pollLast();
                while (count-- > 0) {
                    tmp.append(res.toString());
                }
                res = new StringBuilder(resStack.pollLast() + tmp);
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }

    //错误做法：（只考虑到 xxxk[xxk[]xx] ）
//    public String decodeString(String s) {
//        return decode(s, 0, s.length() - 1);
//    }
//
//    public String decode(String s, int left, int right) {
//        if (left >= right) {
//            return "";
//        }
//        StringBuilder sb = new StringBuilder();
//        int l = left, r = right;
//        while (l < r) {
//            while (l < r && !Character.isDigit(s.charAt(l))) {  //注意，数字可能超过 10
//                l++;
//            }
//            if (l < r) {
//                sb.append(s.substring(left, l));
//            } else {
//                break;
//            }
//            int k = 0;
//            if (Character.isDigit(s.charAt(l))) {
//                k = (int) (s.charAt(l) - '0');
//            }
//            while (l < r && s.charAt(r) != ']') {
//                r--;
//            }
//            if (l < r) {
//                String str = decode(s, l + 1, r - 1);
//                while (k-- > 0) {
//                    sb.append(str);
//                }
//                if (r + 1 < right) {
//                    sb.append(s.substring(r + 1, right));
//                }
//                break;
//            } else {
//                break;
//            }
//        }
//        return sb.toString();
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


/*
T1-20.8.15, >30min
 */