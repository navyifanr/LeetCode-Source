# 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
# 
#  示例: 
# 
#  输入: [0,1,0,3,12]
# 输出: [1,3,12,0,0] 
# 
#  说明: 
# 
#  
#  必须在原数组上操作，不能拷贝额外的数组。 
#  尽量减少操作次数。 
#  
#  Related Topics 数组 双指针 👍 1374 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        i = 0
        j = 1
        size = len(nums)
        while i < j < size:
            if nums[i] != 0:
                i += 1
                j += 1
            else:
                while j < size:
                    if nums[j] == 0:
                        j += 1
                    else:
                        temp = nums[i]
                        nums[i] = nums[j]
                        nums[j] = temp
                        i += 1
                        j += 1
                        break
# leetcode submit region end(Prohibit modification and deletion)
