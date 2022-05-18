# 给定两个字符串 s 和 t，判断它们是否是同构的。 
# 
#  如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
# 
#  每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
# 
#  
# 
#  示例 1: 
# 
#  
# 输入：s = "egg", t = "add"
# 输出：true
#  
# 
#  示例 2： 
# 
#  
# 输入：s = "foo", t = "bar"
# 输出：false 
# 
#  示例 3： 
# 
#  
# 输入：s = "paper", t = "title"
# 输出：true 
# 
#  
# 
#  提示： 
# 
#  
#  可以假设 s 和 t 长度相同。 
#  
#  Related Topics 哈希表 字符串 👍 418 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        hs = dict()
        i = 0
        while i < len(s):
            k = s[i]
            v = t[i]
            if hs.has_key(k) or v in hs.values():
                if hs.has_key(k) and hs.get(k) != v:
                    return False
                if v in hs.values():
                    for ch in hs.keys():
                        if hs.get(ch) == v and ch != k:
                            return False
                i += 1
            else:
                hs[k] = v
                i += 1
        return True
# leetcode submit region end(Prohibit modification and deletion)
