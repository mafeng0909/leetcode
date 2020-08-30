//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = 'ABCCED', 返回 true
//给定 word = 'SEE', 返回 true
//给定 word = 'ABCB', 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 538 👎 0


package com.leetcode.editor.cn;
/**
 * Java：单词搜索
 * 
 * @author: mafeng
 * @data: 2020-08-29 16:06:51
 **/
public class P79WordSearch{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {

        private static boolean flag = false;

        public boolean exist(char[][] board, String word) {
            if (board.length == 0 || word.length() == 0) {
                return false;
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public static boolean dfs(char[][] board, String word, int i, int j, int index) {
            if (index == word.length()) {
                flag = true;
                return true;
            }
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
                return false;
            }

            if (flag) {
                return true;
            }else {
                char c = board[i][j];
                board[i][j] = '*';
                boolean res1 = dfs(board, word, i + 1, j, index + 1);
                boolean res2 = dfs(board, word, i, j + 1, index + 1);
                boolean res3 = dfs(board, word, i - 1, j, index + 1);
                boolean res4 = dfs(board, word, i, j - 1, index + 1);
                board[i][j] = c;
                return res1 || res2 || res3 || res4;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}