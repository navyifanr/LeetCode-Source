//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //方法 1：排序+hashset去重
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int n1 = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] > -n1) {
                    right--;
                } else if (nums[left] + nums[right] < -n1) {
                    left++;
                } else {
                    set.add(new ArrayList<>(Arrays.asList(n1, nums[left], nums[right])));
//                    break; //直接跳出会遗漏符合的情况
                    left++;
                    right--;
                }
            }
        }
        for (ArrayList<Integer> list : set) {
            result.add(list);
        }
        return result;
    }

    //方法 2：排序+手动去重
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int n1 = nums[i];
            if (n1 > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] > -n1) {
                    right--;
                } else if (nums[left] + nums[right] < -n1) {
                    left++;
                } else {
                    result.add(new ArrayList<>(Arrays.asList(n1, nums[left], nums[right])));
//                    break; //直接跳出会遗漏符合的情况
                    left++;
                    right--;
                    //去重
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        return result;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
