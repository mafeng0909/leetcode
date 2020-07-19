//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
// 问总共有多少条不同的路径？
//
//
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？
//
//
//
// 示例 1:
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
//
//
// 示例 2:
//
// 输入: m = 7, n = 3
//输出: 28
//
//
//
// 提示：
//
//
// 1 <= m, n <= 100
// 题目数据保证答案小于等于 2 * 10 ^ 9
//
// Related Topics 数组 动态规划

package com.leetcode.editor.cn;
/**
 * Java：不同路径
 * 分析：动态规划  从右下往左上
 *      原问题与子问题：
 *      状态：dp[i][j] 表示 在坐标[i, j]位置到达右下角有多少种可能
 *      临界条件：dp[m][n] = 1
 *      状态转换方程：dp[i][j] = dp[i + 1][j] + dp[i][j + 1]
 *
 * @author mafeng
 */
public class P62UniquePaths{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int uniquePaths(int m, int n) {
            if (m <= 1 || n <= 1) {
                return 1;
            }

            int[][] dp = new int[m][n];
            dp[m - 1][n - 1] = 1;
            // 先把最下面一行和最上面一行填好
            for (int i = 0; i < m - 1; ++i) {
                dp[i][n - 1] = 1;
            }
            for (int i = 0; i < n - 1; ++i) {
                dp[m - 1][i] = 1;
            }

            for (int i = m - 2; i >= 0; --i) {
                for (int j = n - 2; j >= 0; --j) {
                    dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
                }
            }
            return dp[0][0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
