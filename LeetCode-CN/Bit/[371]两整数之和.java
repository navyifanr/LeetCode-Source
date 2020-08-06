//不使用运算符 + 和 - ，计算两整数 a 、b 之和。 
//
// 示例 1: 
//
// 输入: a = 1, b = 2
//输出: 3
// 
//
// 示例 2: 
//
// 输入: a = -2, b = 3
//输出: 1 
// Related Topics 位运算


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = a ^ b;  //异或，求出不进位的值
            b = (a & b) << 1; //与操作并左移一位，计算进位值
            a = tmp;
        } // 直至进位值为 0， 跳出循环
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T1-8.4, >30min
 */