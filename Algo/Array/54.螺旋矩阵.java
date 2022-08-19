import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 * 
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。


示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 
提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int tb = 0, bb = m - 1;
        int lb = 0, rb = n - 1;
        List<Integer> res = new ArrayList<>();
        while (res.size() < m * n) {
            //顶行
            if (tb <= bb) {
                for (int i = lb; i <= rb; i++) {
                    res.add(matrix[tb][i]);
                }
                tb++;
            }
            //右列
            if (lb <= rb) {
                for (int i = tb; i <= bb; i++) {
                    res.add(matrix[i][rb]);
                }
                rb--;
            }
            //底行
            if (tb <= bb) {
                for (int i = rb; i >= lb; i--) {
                    res.add(matrix[bb][i]);
                }
                bb--;
            }
            //左列
            if (lb <= rb) {
                for (int i = bb; i >= tb; i--) {
                    res.add(matrix[i][lb]);
                }
                lb++;
            }
        }
        return res;
    }
}
// @lc code=end

