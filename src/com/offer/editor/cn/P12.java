package com.offer.editor.cn;

/**
 * @author mafeng
 * @data 2020/8/29
 **/
public class P12 {

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};


    public static void main(String[] args) {

    }

    public static boolean exist(char[][] board, String word) {
        int index = 0;
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(index)) {
                    int[][] visited = new int[row][col];
                    visited[i][j] = 1;
                    boolean flag = dfs(board, word, i, j, index + 1, visited);
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int row, int col, int index, int[][] visited) {
        if (index == word.length()) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length
                && board[newRow][newCol] == word.charAt(index) && visited[newRow][newCol] == 0) {
                visited[newRow][newCol] = 1;
                boolean flag = dfs(board, word, newRow, newCol, index + 1, visited);
                if (flag) {
                    return true;
                }else {
                    visited[newRow][newCol] = 0;
                }
            }
        }
        return false;
    }
}
