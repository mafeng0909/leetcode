//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划

package com.leetcode.editor.cn;
/**
 * Java：最小路径和
 * 分析：动态规划算法
 *     1、原问题和子问题：
 *     2、状态：dp[i][j] 即 到达位置[i][j]所需要的最小路程
 *     3、临界状态：dp[0][0] = grid[0][0]
 *     4、状态转换方程：
 *        当 i !=0 && j != 0时，
 *             dp[i][j] = min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
 *
 * @author mafeng
 */
public class P64MinimumPathSum{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int minPathSum(int[][] grid) {
            if (grid.length == 0) {
                return 0;
            }
            int row = grid.length;
            int col = grid[0].length;
            int[][] dp = new int[row][col];
            // 临界状态
            dp[0][0] = grid[0][0];
            // 将第一行填充好
            for (int j = 1; j < col; j++) {
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            }
            for (int i = 1; i < row; i++) {
                // 把每行的第一个元素先填好
                dp[i][0] = dp[i - 1][0] + grid[i][0];
                for (int j = 1; j < col; j++) {
                    // 状态转换方程
                    dp[i][j] = Integer.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
            return dp[row - 1][col - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}