//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 方法 1：暴力法——超时
    public boolean validPalindrome(String s) {
        int len = s.length();
        if (isPalindrome(s)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        boolean isValid = false;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                isValid = isPalindrome(s.substring(1, len));
            } else if (i == len - 1) {
                isValid = isPalindrome(s.substring(0, len - 1));
            } else {
                sb.setLength(0);   //注意要清空
                isValid = isPalindrome(sb.append(s.substring(0, i)).append(s.substring(i + 1, len)).toString());
            }
            if (isValid) {
                return true;
            }
        }
        return false;
    }

    public boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //方法 2：双指针
    public boolean validPalindrome(String s) {
        int len = s.length();
        int i = 0, j = len - 1;
        while (i < j) {
            char chl = s.charAt(i), chr = s.charAt(j);
            if (chl == chr) {
                i++;
                j--;
            } else {
                boolean validL = true, validR = true;
                for (int k = i + 1, l = j; k < l; k++, l--) {
                    if (s.charAt(k) != s.charAt(l)) {
                        validL = false;
                        break;
                    }
                }
                for (int k = i, l = j - 1; k < l; k++, l--) {
                    if (s.charAt(k) != s.charAt(l)) {
                        validR = false;
                        break;
                    }
                }
                return validL || validR;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
