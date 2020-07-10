//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window


import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //暴力法，时间复杂度 O(nk)  空间复杂度 O(n - k + 1)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int slow = 0;
        int fast = k - 1;
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        while (fast < nums.length) {
            int max = Integer.MIN_VALUE;
            for (int i = slow; i <= fast; i++) {
                max = Math.max(max, nums[i]);
            }
            result[index++] = max;
            slow++;
            fast++;
        }
        return result;
    }

    //双向队列，时间复杂度 O(n)， 空间复杂度 O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            resetQueue(nums, queue, i, k);
            queue.add(i);
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        result[index++] = nums[maxIndex];
        for (int i = k; i < nums.length; i++) {
            resetQueue(nums, queue, i, k);
            queue.add(i);
            result[index++] = nums[queue.peekFirst()];
        }
        return result;
    }

    public void resetQueue(int[] nums, LinkedList<Integer> queue, int i, int k) {
        //窗口第一个元素是最大值时
        if (!queue.isEmpty() && queue.peekFirst() == i - k) {
            queue.pollFirst();
        }
        while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
            queue.pollLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T2-7.8 > 30min
 */