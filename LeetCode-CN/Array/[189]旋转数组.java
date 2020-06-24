//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1. 暴力法：直接 k 次移动最后一个元素到前面；时间复杂度 O(n*k), 空间复杂度 O(1)
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        while (k-- > 0) {
            int pre = nums[0];
            nums[0] = nums[len - 1];
            for (int i = 1; i < len; i++) {
                int cur = nums[i];
                nums[i] = pre;
                pre = cur;
            }
        }
    }

    //2. 通过额外数组存储排好顺序，时间复杂度：O(n), 空间复杂度：O(n)
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[(k + i) % len] = nums[i];
//            temp[k] = nums[i];  //error 注意 k 超过 nums 长度数组越界问题
//            k = (++k >= len) ? k - len : k;
        }
        for (int i = 0; i < len; i++) {
            nums[i] = temp[i];
        }
    }

    //3. 多次反转数组
    public void rotate(int[] nums, int k) {
        k %= nums.length;  //注意要防止 k 大于数组长度，超出边界
        reverse(nums, 0, nums.length -1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
