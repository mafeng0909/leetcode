//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划

package com.leetcode.editor.cn;

import java.util.List;

/**
 * Java：三角形最小路径和
 * 分析：动态规划算法   自底向上
 *     1、原问题和子问题：
 *     2、状态：dp[i][j] 即到每个位置的最短路径和
 *     3、临界状态：最后一行与原triangle最后一行一致
 *     4、状态转换方程：dp[i][j] = min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j]
 *
 * @author mafeng
 */
public class P120Triangle{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle.size() == 0) {
                return 0;
            }
            int row = triangle.size();
            // 最后一行即最多元素的一行
            int col = triangle.get(row - 1).size();
            int[][] dp = new int[row][col];
            // 临界条件：最后一行数据不变
            int index = 0;
            for (Integer integer : triangle.get(row - 1)) {
                dp[row - 1][index++] = integer;
            }
            for (int i = row - 2; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    // 状态转换方程
                    dp[i][j] = Integer.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }
            return dp[0][0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}