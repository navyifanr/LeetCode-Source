//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        //或者用系统排序
//        Arrays.sort(strs, ((o1, o2) -> (o1 + o2).compareTo(o2 + o1)));
        quickSort(strs, 0 , strs.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    //直接用快排比较拼接的字符串
    public void quickSort(String[] strs, int start, int end) {
        String key = strs[start];
        int i = start;
        int j = end;
        while (i < j) {
            while ((strs[j] + key).compareTo(key + strs[j]) >= 0 && i < j) j--;
            strs[i] = strs[j];
            while ((strs[i] + key).compareTo(key + strs[i]) <= 0 && i < j) i++;
            strs[j] = strs[i];
        }
        strs[i] = key;
        if (i - 1 > start) {
            quickSort(strs, start, i - 1);
        }
        if (i + 1 < end) {
            quickSort(strs, i + 1, end);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T1-7.12, >30min
 */