# 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
# 
#  
# 
#  示例： 
# 
#  输入："Let's take LeetCode contest"
# 输出："s'teL ekat edoCteeL tsetnoc"
#  
# 
#  
# 
#  提示： 
# 
#  
#  在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
#  
#  Related Topics 双指针 字符串 👍 389 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        ls = list(s)
        i = 0
        for j, ch in enumerate(ls):
            idx = j
            if ch == ' ' or j == len(ls) - 1:
                if ch == ' ':
                    j -= 1
                while i <= j:
                    tmp = ls[i]
                    ls[i] = ls[j]
                    ls[j] = tmp
                    i += 1
                    j -= 1
                i = idx + 1
        return ''.join(ls)

# leetcode submit region end(Prohibit modification and deletion)
