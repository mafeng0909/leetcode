package com.test.editor.cn.huawei;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/8/12
 **/
public class Test081202 {

    public static boolean flag = false;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        int[][] visit = new int[row][col];
        visit[0][0] = 1;
        dfs(arr, 0, 0, n, visit);

        if (flag) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }

    }

    public static boolean dfs(int[][] arr, int i, int j, int n, int[][] visit) {
        if (i >= arr.length || i < 0 || j < 0 || j >= arr[0].length
                || arr[i][j] == 0 || visit[i][j] == 2) {
            return false;
        }
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            return true;
        }

        visit[i][j] = 1;
        boolean res = dfs(arr, i + dx[0] * n, j * dy[0] * n, n, visit) ||
                      dfs(arr, i + dx[1] * n, j * dy[1] * n, n, visit) ||
                      dfs(arr, i + dx[2] * n, j * dy[2] * n, n, visit) ||
                      dfs(arr, i + dx[3] * n, j * dy[3] * n, n, visit);
        if (!res) {
            visit[i][j] = 2;
            return false;
        }else {
            return true;
        }
    }
}
