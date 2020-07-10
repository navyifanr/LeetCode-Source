//机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令： 
//
// 
// -2：向左转 90 度 
// -1：向右转 90 度 
// 1 <= x <= 9：向前移动 x 个单位长度 
// 
//
// 在网格上有一些格子被视为障碍物。 
//
// 第 i 个障碍物位于网格点 (obstacles[i][0], obstacles[i][1]) 
//
// 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。 
//
// 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。 
//
// 
//
// 示例 1： 
//
// 输入: commands = [4,-1,3], obstacles = []
//输出: 25
//解释: 机器人将会到达 (3, 4)
// 
//
// 示例 2： 
//
// 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出: 65
//解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
// 
//
// 
//
// 提示： 
//
// 
// 0 <= commands.length <= 10000 
// 0 <= obstacles.length <= 10000 
// -30000 <= obstacle[i][0] <= 30000 
// -30000 <= obstacle[i][1] <= 30000 
// 答案保证小于 2 ^ 31 
// 
// Related Topics 贪心算法


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {
        //北东南西
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //0123  北东南西
        int direction = 0;

        //障碍数据集
        HashSet<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," +obs[1]);
        }

        int curX = 0, curY = 0;
        int result = 0; //最小设置为 0，避免一步都没走的情况
        for (int com : commands) {
            int nextX = 0, nextY = 0;
            if (com > 0) {
                for (int i = 0; i < com; i++) {  //一步一步走
                    nextX = curX + directions[direction][0];
                    nextY = curY + directions[direction][1];
                    if (obstacleSet.contains(nextX + "," + nextY)) break;  //遇到障碍跳出循环
                    curX = nextX;
                    curY = nextY;
                    result = Math.max(result, curX * curX + curY * curY);
                }
            } else {
                direction = com == -1 ? (direction + 1) % 4 : (direction + 3) % 4;
            }
        }
        return result;
    }

//    public int robotSim(int[] commands, int[][] obstacles) {
//        HashMap<Integer, Integer> xPoints = new HashMap<>();
//        HashMap<Integer, Integer> yPoints = new HashMap<>();
//        int index = 0;
//        for (int[] point : obstacles) {
//            xPoints.put(index, point[0]);
//            yPoints.put(index, point[1]);
//            index++;
//        }
//        int finalX = 0;
//        int finalY = 0;
//        //默认指北正方向运动
//        boolean alongY = true;
//        boolean positive = true;
//        for (int i = 0; i < commands.length; i++) {
//            int com = commands[i];
//            if (com < 0) {
//                if (alongY) {
//                    if (positive) {
//                        positive = com == -1;
//                    } else {
//                        positive = com == -2;
//                    }
//                } else {
//                    if (positive) {
//                        positive = com == -2;
//                    } else {
//                        positive = com == -1;
//                    }
//                }
//                alongY = !alongY;
//            } else {
//                if (obstacles == null || obstacles.length == 0 || (!xPoints.containsValue(finalX) && !yPoints.containsValue(finalY))) {
//                    if (alongY) {
//                        finalY += positive ? com : -com;
//                    } else {
//                        finalX += positive ? com : -com;
//                    }
//                } else {
//                    if (alongY) {
//                        if (xPoints.containsValue(finalX)) {
//                            if (positive) {
//                                int tmpY = finalY + com;
////                                if (tmpY > )
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return finalX * finalX + finalY * finalY;
//    }
//
//    public boolean isBlock(int x, int y, int[][] ob)
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T2-7.7 15min
 */