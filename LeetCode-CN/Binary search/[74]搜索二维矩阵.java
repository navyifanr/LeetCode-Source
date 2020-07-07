//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        //注意前置条件
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int rLeft = 0;
        int rRight = row - 1;  //不要搞反了 row, col
        int midRow = 0;
        while (rLeft <= rRight) {
            midRow = rRight + (rLeft - rRight) / 2;
            if (target == matrix[midRow][0]) {
                return true;
            } else if (target < matrix[midRow][0]) {
                rRight = midRow - 1;
            } else {
                if (target == matrix[midRow][col - 1]) {
                    return true;
                } else if (target > matrix[midRow][col - 1]) {
                    rLeft = midRow + 1;
                } else {
                    break;
                }
            }
        }
        int low = 0;
        int high = col - 1;
        while (low <= high) {
            int mid = high + (low - high) / 2;
            if (target == matrix[midRow][mid]) {
                return true;
            } else if (target < matrix[midRow][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
