package com.niuke.editor.cn.jd;

/**
 * 题目：年终奖
 * 分析：利用贪心，从下至上，每次选择最大的那一个
 *
 * @author mafeng
 * @data 2020/8/18
 **/
public class Test01 {
    public static void main(String[] args) {

    }

    public int getMost(int[][] board) {
        // write code here
        if (board.length < 1 || board[0].length < 1) {
            return 0;
        }
        int row = board.length;
        int col = board[0].length;
        int[][] res = new int[row][col];

        res[row - 1][col - 1] = board[row - 1][col - 1];
        // 填充最后一行
        for (int i = col - 2; i >= 0; i--) {
            res[row - 1][i] = board[row - 1][i] + res[row - 1][i + 1];
        }
        // 填充最后一列
        for (int j = row - 2; j >= 0; j--) {
            res[j][col - 1] = board[j][col - 1] + res[j + 1][col - 1];
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >=0; j--) {
                if (res[i][j + 1] > res[i + 1][j]) {
                    res[i][j] = board[i][j] + res[i][j + 1];
                }else {
                    res[i][j] = board[i][j] + res[i + 1][j];
                }
            }
        }
        return res[0][0];
    }
}
