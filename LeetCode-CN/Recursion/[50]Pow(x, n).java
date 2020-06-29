//实现 pow(x, n) ，即计算 x 的 n 次幂函数。
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找

/**
 * 1. 注意 n 有可能是负整数
 * 2. n = -2^31 直接取反会越界
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //方法1. 递归 时间复杂度 O(log n)，空间复杂度 O(log n)
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        boolean isNegative = n < 0;
        boolean isOver = false;
        if (isNegative) {
            if (n == -2147483648) {
                isOver = true;
                n = -(n + 1);
            } else {
                n = -n;  //注意，n = -2^31 直接取反会越界
            }
        }
        double half = myPow(x, (int) n / 2);
        double result = n % 2 == 0 ? half * half : half * half * x;
        result = isOver ? result / x : result;
        return isNegative ? 1 / result : result;
    }

    //方法2：快速幕+迭代，时间复杂度 O(log n)，空间复杂度 O(1)
    public double myPow(double x, int n) {
        long count = n;
        return count > 0 ? fastPow(x, count) : 1 / fastPow(x, -count);
    }

    public double fastPow(double x, long n) {
        double ans = 1.0;
        double xSquare = x;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= xSquare;
            }
            xSquare *= xSquare;
            n /= 2;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
