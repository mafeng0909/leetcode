//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//
//
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。
//
// 说明：m 和 n 的值均不超过 100。
//
// 示例 1:
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
//
// Related Topics 数组 动态规划
// 👍 308 👎 0

package com.leetcode.editor.cn;

/**
 * Java：不同路径 II
 * 分析：动态规划  从左上到右下
 *      原问题与子问题：
 *      状态：dp[i][j] 表示 在坐标[i, j]位置到达右下角有多少种可能
 *      临界条件：dp[m][n] = 1
 *      状态转换方程：dp[i][j] = dp[i + 1][j] + dp[i][j + 1]
 *
 * @author mafeng
 */
public class P63UniquePathsIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            if (obstacleGrid[0][0] == 1) {
                return 0;
            }
            obstacleGrid[0][0] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    // 如果有障碍物，则直接置为0
                    if (obstacleGrid[i][j] == 1) {
                        obstacleGrid[i][j] = 0;
                    }else {
                        // 填最上面一行
                        if (i == 0) {
                            obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                        // 填最左边一列
                        }else if (j == 0) {
                            obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                        }else {
                            obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                        }
                    }

                }
            }
            return obstacleGrid[m - 1][n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
