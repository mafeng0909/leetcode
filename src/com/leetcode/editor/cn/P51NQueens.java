//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
// 示例:
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
//
//
//
//
// 提示：
//
//
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ）
//
// Related Topics 回溯算法

package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Java：N皇后
 * @author mafeng
 */
public class P51NQueens{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        List<List<String>> lists = solution.solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println(list.toString());
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();
            String[][] locations = new String[n][n];
            for (String[] location : locations) {
                Arrays.fill(location, ".");
            }
            int[][] mark = new int[n][n];
            dfs(n, 0, mark, locations, result);
            return result;
        }

        public static void dfs(int n, int row, int[][] mark, String[][] locations, List<List<String>> result) {
            if (row == n) {
                ArrayList<String> list = new ArrayList<>();
                for (String[] location : locations) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String s : location) {
                        stringBuilder.append(s);
                    }
                    list.add(stringBuilder.toString());
                }
                result.add(list);
                return;
            }
            for (int col = 0; col < n; col++) {
                if (mark[row][col] == 0) {
                    // 记住当前标记状态，方便回溯
                    int[][] oldMark = new int[n][n];
                    // 进行深拷贝
                    for (int i = 0; i < oldMark.length; i++) {
                        System.arraycopy(mark[i], 0, oldMark[i], 0, oldMark[0].length);
                    }
                    locations[row][col] = "Q";
                    // 更新标记
                    updateMark(row, col, mark);
                    dfs(n, row + 1, mark, locations, result);
                    // 回溯
                    mark = oldMark;
                    locations[row][col] = ".";
                }
            }
        }

        public static void updateMark(int row, int col, int[][] mark) {
            // 方向数组
            int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
            int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
            mark[row][col] = 1;
            for (int i = 1; i < mark.length; i++) {
                for (int j = 0; j < 8; j++) {
                    int newRow = row + i * dr[j];
                    int newCol = col + i * dc[j];
                    if (newRow >= 0 && newRow < mark.length
                            && newCol >= 0 && newCol < mark.length
                            && mark[newRow][newCol] == 0) {
                        mark[newRow][newCol] = 1;
                    }
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
