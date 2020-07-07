//让我们一起来玩扫雷游戏！ 
//
// 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）
//地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。 
//
// 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板： 
//
// 
// 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。 
// 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。 
// 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。 
// 如果在此次点击中，若无更多方块可被揭露，则返回面板。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 
//
//[['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'M', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E']]
//
//Click : [3,0]
//
//输出: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
// 
//
// 示例 2： 
//
// 输入: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Click : [1,2]
//
//输出: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'X', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
// 
//
// 
//
// 注意： 
//
// 
// 输入矩阵的宽和高的范围为 [1,50]。 
// 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。 
// 输入面板不会是游戏结束的状态（即有地雷已被挖出）。 
// 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。 
// Related Topics 深度优先搜索 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] dicts = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0], col = click[1];
        int m = board.length, n = board[0].length;
        //有雷，或已揭开雷
        if (board[row][col] == 'M' || board[row][col] == 'X') {
            board[row][col] = 'X';
            return board;
        }

        int count = 0;
        //点击位置附近八个方向雷的数量
        for (int[] dict : dicts) {
            int newRow = row + dict[0];
            int newCol = col + dict[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && board[newRow][newCol] == 'M') {
                count++;
            }
        }
        //如果点击位置附近八个方向雷的数量大于 0，标记点击位置雷数量，并 return
        if (count > 0) {
            board[row][col] = (char) (count + '0');
            return board;
        }

        //修改点击位置为 B，并再次递归查找附近为 E 的点
        board[row][col] = 'B';
        for (int[] dict : dicts) {
            int newRow = row + dict[0];
            int newCol = col + dict[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && board[newRow][newCol] == 'E') {
                updateBoard(board, new int[]{newRow, newCol});
            }
        }

        return board;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
