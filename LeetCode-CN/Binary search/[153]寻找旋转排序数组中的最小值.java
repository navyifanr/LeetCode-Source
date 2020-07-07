//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 你可以假设数组中不存在重复元素。 
//
// 示例 1: 
//
// 输入: [3,4,5,1,2]
//输出: 1 
//
// 示例 2: 
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = high + (low - high) / 2;
            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] > nums[low]) { //前半段有序，则在后半段
                low = mid + 1;
            } else {  //后半段有序
                high = mid - 1;
            }
        }
        return nums[high];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T1-7.3, 33min
 */