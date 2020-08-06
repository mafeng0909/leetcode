package com.niuke.editor.cn.shopee;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/8/5
 **/
public class Test1 {

    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[x + 1][y + 1];
        while (n > 0){
            int row = sc.nextInt();
            int col = sc.nextInt();
            arr[row][col] = -1;
            sc.nextLine();
            n--;
        }
//        dfs(arr, x, y);
        dynamicProgramming(arr, x, y);

        System.out.println(count);
    }

    /**
     * DFS深度优先搜索
     *
     * @param arr
     * @param row
     * @param col
     */
    public static void dfs(int[][] arr, int row, int col) {
        if (row == 0 && col == 0) {
            count++;
            return;
        }
        if (row < 0 || col < 0 || arr[row][col] == -1) {
            return;
        }
        arr[row][col] = -1;
        dfs(arr, row - 1, col);
        dfs(arr, row, col - 1);
        arr[row][col] = 0;
    }

    /**
     * 动态规划
     *
     * @param dp
     * @param row
     * @param col
     */
    public static void dynamicProgramming(int[][] dp, int row, int col) {
        // 填充第一列
        for (int i = 0; i <= row; i++) {
            if (dp[i][0] != -1) {
                dp[i][0] = 1;
            }
        }
        // 填充第一行
        for (int i = 0; i <= col; i++) {
            if (dp[0][i] != -1) {
                dp[0][i] = 1;
            }
        }
        // 遍历填充
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }
                if (dp[i - 1][j] != -1) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (dp[i][j - 1] != -1) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        count = dp[row][col];
    }
}
