package com.test.editor.cn.dajiang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/8/16
 **/
public class Test081602 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[n][n];
        for (int[] ints : arr) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x][y] = sc.nextInt();
            sc.nextLine();
        }
        int target = sc.nextInt();

        int[] res = diJskTa(arr, 0);
        System.out.println(res[target]);

    }

    public static int[] diJskTa(int[][] weight, int start) {
        int n = weight.length;
        int[] shortPath = new int[n];
        int[] visited = new int[n];
        shortPath[0] = 0;
        visited[0] = 1;
        for (int count = 1; count <= n - 1; count++) {
            int k = -1;
            int dMin = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0 && weight[start][i] < dMin) {
                    dMin = weight[start][i];
                    k = i;
                }
            }
            shortPath[k] = dMin;
            visited[k] = 1;
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]) {
                    weight[start][i] = weight[start][k] + weight[k][i];
                }
            }
        }
        return shortPath;


    }
}
