/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 * 
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。


示例 1：


输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]
示例 2：

输入：n = 1
输出：[[1]]
 

提示：

1 <= n <= 20

 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int tb = 0, bb = n - 1;
        int lb = 0, rb = n - 1;
        int num = 1;
        while (num <= n * n) {
            if (tb <= bb) {
                for (int i = lb; i <= rb; i++) {
                    matrix[tb][i] = num++;
                }
                tb++;
            }
            if (lb <= rb) {
                for (int i = tb; i <= bb; i++) {
                    matrix[i][rb] = num++;
                }
                rb--;
            }
            if (tb <= bb) {
                for (int i = rb; i >= lb; i--) {
                    matrix[bb][i] = num++;
                }
                bb--;
            }
            if (lb <= rb) {
                for (int i = bb; i >= tb; i--) {
                    matrix[i][lb] = num++;
                }
                lb++;
            }
        }
        return matrix;
    }
}
// @lc code=end

