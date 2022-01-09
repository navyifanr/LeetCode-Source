# 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。 
#  
# 
#  示例 1 ： 
# 
#  
# 输入：num = "1432219", k = 3
# 输出："1219"
# 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
#  
# 
#  示例 2 ： 
# 
#  
# 输入：num = "10200", k = 1
# 输出："200"
# 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
#  
# 
#  示例 3 ： 
# 
#  
# 输入：num = "10", k = 2
# 输出："0"
# 解释：从原数字移除所有的数字，剩余为空就是 0 。
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= k <= num.length <= 10⁵ 
#  num 仅由若干位数字（0 - 9）组成 
#  除了 0 本身之外，num 不含任何前导零 
#  
#  Related Topics 栈 贪心 字符串 单调栈 👍 708 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):

    def removeKdigits(self, num, k):
        """
        :type num: str
        :type k: int
        :rtype: str
        """
        if len(num) == k:
            return '0'
        stack = []
        remain = len(num) - k
        for n in num:
            while k and stack and stack[-1] > n:
                stack.pop()
                k -= 1
            stack.append(n)
        return ''.join(stack[:remain]).lstrip('0') or '0'

    # # 有bug
    # def removeKdigits(self, num, k):
    #     """
    #     :type num: str
    #     :type k: int
    #     :rtype: str
    #     """
    #     if len(num) == k:
    #         return '0'
    #     result = ''
    #     nums = list(num)
    #     idx = 0
    #     count = 0
    #     for i, ch in enumerate(nums[1:]):
    #         if count == k:
    #             break
    #         if nums[idx] < ch:
    #             nums[i + 1] = -1
    #             count += 1
    #         elif nums[idx] == ch:  # 全部是相同的呢？
    #             idx = i + 1
    #         else:
    #             nums[idx] = -1
    #             idx = i + 1
    #             count += 1
    #     for i, ch in enumerate(nums):
    #         if ch == '0' and len(result) == 0:
    #             continue
    #         if ch != -1:
    #             result += str(ch)
    #     if len(result) == 0:
    #         result = '0'
    #     return result
# leetcode submit region end(Prohibit modification and deletion)
