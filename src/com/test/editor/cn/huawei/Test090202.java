package com.test.editor.cn.huawei;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/2
 **/
public class Test090202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().trim().split(",");
        int row = Integer.parseInt(strings[0]);
        int col = Integer.parseInt(strings[1]);
        char[][] arr = new char[row][col];
        for (int i = 0; i < row; i++) {
            String s = sc.nextLine().trim();
            for (int j = 0; j < col; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        System.out.println(isLake(arr));
    }

    public static int isLake(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int numOfLake = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == 'S') {
                    numOfLake++;
                    dfs(grid, r, c);
                }
            }
        }
        return numOfLake;
    }

    private static void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 'H') {
            return;
        }
        grid[r][c] = 'H';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

}
