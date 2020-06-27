//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //1. 排序 时间复杂度 O(nlog n), 空间复杂度 O(log n)
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    //2. 堆，使用 PriorityQueue 小顶堆，  时间复杂度 O(nlog n), 空间复杂度 O(n)
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (Integer i : arr) {
            queue.offer(i);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    //3. 堆，使用 PriorityQueue 大顶堆，  时间复杂度 O(nlog k), 空间复杂度 O(k)
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(((o1, o2) -> o2 - o1));
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                queue.add(arr[i]);
            } else {
                if (arr[i] < queue.peek()) {
                    queue.poll();
                    queue.add(arr[i]);
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
