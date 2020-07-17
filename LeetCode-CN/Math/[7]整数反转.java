//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //方法 1：将值转为 long 型，最终比对最大最小整型看是否溢出
    public int reverse(int x) {
        long tmp = x;
        tmp = Math.abs(tmp);
        long res = 0;
        while (tmp > 0) {
            res = res * 10 + tmp % 10;
            tmp /= 10;
        }
        res = x > 0 ? res : -res;
        //注意不能直接用 long 和 Integer.MAX_VALUE 对比
        return res > 0x7fffffff || res < 0x80000000 ? 0 : (int) res;
    }

    //方法 2：在翻转的时候，判断是否有可能溢出，溢出则直接 return 0
    public int reverse(int x) {
        int res = 0;
        int tmp = Math.abs(x);
        while (tmp > 0) {
            // 也就是判断后面的运算中 res * 10 + tmp % 10 是否越界
            if (res > (Integer.MAX_VALUE - tmp % 10) / 10) {
                return 0;
            }
            res = res * 10 + tmp % 10;
            tmp /= 10;
        }
        return x > 0 ? res : -res;
    }

    //方法 3：整型转字符串，直接翻转字符串，再由字符串转整型，try 异常，出现异常返回 0
    public int reverse(int x) {
        String str = new StringBuilder(String.valueOf(x > 0 ? x : -x)).reverse().toString();
        int res = 0;
        try {
            res = Integer.valueOf(str);
        } catch (Exception e) {
            return 0;
        }
        return x > 0 ? res : -res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


