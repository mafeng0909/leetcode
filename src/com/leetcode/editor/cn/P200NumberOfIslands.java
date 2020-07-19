//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
//
// 此外，你可以假设该网格的四条边均被水包围。
//
//
//
// 示例 1:
//
// 输入:
//11110
//11010
//11000
//00000
//输出: 1
//
//
// 示例 2:
//
// 输入:
//11000
//11000
//00100
//00011
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
//
// Related Topics 深度优先搜索 广度优先搜索 并查集

package com.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Java：岛屿数量
 * 分析：深度优先遍历
 *      以上下左右的顺序进行遍历，每进行一次完整的dfs，便说明有一个岛屿（当四周都有水，便会退出dfs）
 *      按习惯来讲：本人会选第三种方案，即采用标记数组，以及相应的递归方式
 *
 * @author mafeng
 */
public class P200NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        // 第一种形式：采用标记数组和位置坐标
        public int numIslands(char[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int row = grid.length;
            int col = grid[0].length;
            // 定义一个标记数组
            char[][] mark = new char[row][col];
            for (char[] chars : mark) {
                Arrays.fill(chars, '0');
            }
            // 记录岛屿数量
            int num = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (mark[i][j] == '0' && grid[i][j] == '1') {
                        dfs(grid, mark, i, j);
                        num++;
                    }
                }
            }
            return num;
        }

        public void dfs(char[][] grid, char[][] mark, int x, int y) {
            int row = grid.length;
            int col = grid[0].length;
            // 采用位置坐标
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            // 标记（x，y）为已走过
            mark[x][y] = '1';
            // 依照上下左右的顺序遍历
            for (int i = 0; i < dx.length; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 临界条件
                if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                    continue;
                }
                if (mark[newX][newY] == '0' && grid[newX][newY] == '1') {
                    dfs(grid, mark, newX, newY);
                }
            }
        }

        // 第二种形式：直接在原数组中将走过的标为0
        public int numIslands2(char[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            // 记录岛屿数量
            int num = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        dfs2(grid, i, j);
                        num++;
                    }
                }
            }
            return num;
        }

        public void dfs2(char[][] grid, int x, int y) {
            // 临界条件
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                return;
            }
            if (grid[x][y] == '0') {
                return;
            }
            // 将走过的都变为‘0’
            grid[x][y] = '0';
            dfs2(grid, x - 1, y);
            dfs2(grid, x + 1, y);
            dfs2(grid, x, y - 1);
            dfs2(grid, x, y + 1);
        }

        // 第三种形式：采用标记数组
        public int numIslands3(char[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int row = grid.length;
            int col = grid[0].length;
            // 定义一个标记数组
            char[][] mark = new char[row][col];
            for (char[] chars : mark) {
                Arrays.fill(chars, '0');
            }
            // 记录岛屿数量
            int num = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (mark[i][j] == '0' && grid[i][j] == '1') {
                        dfs3(grid, mark, i, j);
                        num++;
                    }
                }
            }
            return num;
        }

        public void dfs3(char[][] grid, char[][] mark, int x, int y) {
            // 临界条件
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                return;
            }
            if (mark[x][y] == '1' || grid[x][y] == '0') {
                return;
            }
            // 标记（x，y）为已走过
            mark[x][y] = '1';

            dfs3(grid, mark, x - 1, y);
            dfs3(grid, mark, x + 1, y);
            dfs3(grid, mark, x, y - 1);
            dfs3(grid, mark, x, y + 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
