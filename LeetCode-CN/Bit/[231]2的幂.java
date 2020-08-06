//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //方法 1：(x & (x - 1)) 去掉 x 最右边的 1
    public boolean isPowerOfTwo(int n) {
        long x = (long) n;                         // 注意整数可能越界   -2147483648
        return (n != 0) && (x & (x - 1)) == 0;     // 注意运算优先级
    }

    //方法 2：(x & -x) 只保留 x 最右边的 1
    public boolean isPowerOfTwo(int n) {
        long x = (long) n;
        return (x != 0) && (x & -x) == x;     // 注意运算优先级
    }
}
//leetcode submit region end(Prohibit modification and deletion)
