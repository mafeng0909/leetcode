package com.test.editor.cn.baidu;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2021/2/7
 **/
public class Test020702 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        // 新建一个二维数组，然后读取进行填入（省略）

        char[][] board = {{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}};
        solve(board);
    }

    public static void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j, row, col);
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }

        // 输出
        for (char[] chars : board) {
            for (int j = 0; j < col; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }

    public static void dfs(char[][] board, int i, int j, int row, int col) {
        board[i][j] = 'Y';
        if ((i - 1 >= 0) && board[i - 1][j] == 'O') {
            dfs(board, i - 1, j, row, col);
        }
        if ((i + 1 < row) && board[i + 1][j] == 'O') {
            dfs(board, i + 1, j, row, col);
        }
        if ((j - 1 >= 0) && board[i][j - 1] == 'O') {
            dfs(board, i, j - 1, row, col);
        }
        if ((j + 1 < col) && board[i][j + 1] == 'O') {
            dfs(board, i, j + 1, row, col);
        }
    }
}
