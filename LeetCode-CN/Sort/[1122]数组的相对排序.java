//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //计数排序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] nums = new int[1001], res = new int[arr1.length];
        int k = 0;
        for (int i : arr1) {
            nums[i]++;
        }
        for (int j : arr2) {
            while (nums[j]-- > 0) {
                res[k++] = j;
            }
        }
        for (int p = 0; p < nums.length; p++) {
            while (nums[p]-- > 0) {
                res[k++] = p;
            }
        }
        return res;
    }


//    public int[] relativeSortArray(int[] arr1, int[] arr2) {
//        int len1 = arr1.length;
//        int len2 = arr2.length;
//        int target, temp;
//        int i = 0;
//        for (int j = 0; j < len1;) {
//            if (i < len2) {
//                target = arr2[i++];
//            } else {
//                target = arr2[j];
//            }
//            for (int k = j; j < len1 && k < len1; k++) {
//                if (i < len2) {
//                    if (arr1[k] == target) {
//                        temp = arr1[j];
//                        arr1[j] = arr1[k];
//                        arr1[k] = temp;
//                        j++;
//                    }
//                } else {
//                    if (arr1[k] < target) {
//                        temp = arr1[j];
//                        arr1[j] = arr1[k];
//                        arr1[k] = temp;
//                    }
//                }
//            }
//        }
//        return arr1;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
