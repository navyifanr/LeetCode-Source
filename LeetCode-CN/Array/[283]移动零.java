//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针

/**
 * 1. 暴力法：(略) 双重遍历；时间复杂度 O(n^2), 空间复杂度 O(1)
 * 2. 双指针法：慢指针为0的索引；时间复杂度 O(n), 空间复杂度 O(1)
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //双指针
    public void moveZeroes(int[] nums) {
        int zeroIndex = -1;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == 0) {
                if (zeroIndex == -1) {
                    zeroIndex = index;
                }
            } else {
                if (zeroIndex != -1) {
                    nums[zeroIndex] = nums[index];
                    nums[index] = 0;
                    zeroIndex++;
                }
            }
            index++;
        }
    }

    // 双指针：代码优化版
    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] != 0) {
                int temp = nums[zeroIndex];
                nums[zeroIndex++] = nums[index];
                nums[index] = temp; // 注意 index++ 不能放在这里，也不能直接赋值 0，否则第一个数非0的情况会异常
            }
            index++;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
