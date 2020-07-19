//
//
// 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿
//过地下城并通过对抗恶魔来拯救公主。 
//
// 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。 
//
// 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么
//包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。 
//
// 为了尽快到达公主，骑士决定每次只向右或向下移动一步。 
//
// 
//
// 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。 
//
// 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。 
//
// 
// 
// -2 (K) 
// -3 
// 3 
// 
// 
// -5 
// -10 
// 1 
// 
// 
// 10 
// 30 
// -5 (P) 
// 
// 
//
//
// 
//
// 说明: 
//
// 
// 
// 骑士的健康点数没有上限。 
// 
// 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。 
// Related Topics 二分查找 动态规划

package com.leetcode.editor.cn;
/**
 * Java：地下城游戏
 * 分析：动态规划算法  自右下向左上
 *     1、原问题和子问题：
 *     2、状态：dp[i][j] 即 至少需要多少血量，才能到达最后（右下角）
 *     3、临界状态：
 *           dp[row - 1][col - 1] = max(1, 1 - dungeon[row - 1][col - 1])
 *     4、状态转换方程：
 *           dpMin = min(dp[i + 1][j], dp[i][j + 1])
 *           dp[i][j] = max(1, dpMin - dungeon[i][j])
 *
 * @author mafeng
 */
public class P174DungeonGame{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            if (dungeon.length == 0) {
                return 0;
            }
            int row = dungeon.length;
            int col = dungeon[0].length;
            int[][] dp = new int[row][col];
            // 临界条件
            dp[row - 1][col - 1] = Math.max(1, 1 - dungeon[row - 1][col - 1]);
            // 将最后一行填充好
            for (int j = col - 2; j >= 0; j--) {
                dp[row - 1][j] = Math.max(1, dp[row - 1][j + 1] - dungeon[row - 1][j]);
            }
            for (int i = row - 2; i >= 0; i--) {
                // 将每一列的最后一个元素填充好
                dp[i][col - 1] = Math.max(1, dp[i + 1][col - 1] - dungeon[i][col - 1]);
                for (int j = col - 2; j >= 0; j--) {
                    // 状态转换方程
                    int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = Math.max(1, min - dungeon[i][j]);
                }
            }
            return dp[0][0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}