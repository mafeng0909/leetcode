package com.test.editor.cn.webank;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/27
 **/
public class Test092702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 顺时针x
        int x = sc.nextInt();
        if (x < 0) {
            x = 0;
        }
        x %= 4;
        // 水平
        int y = sc.nextInt();
        if (y < 0) {
            y = 0;
        }
        y %= 2;
        // 逆时针
        int z = sc.nextInt();
        if (z < 0) {
            z = 0;
        }
        z %= 4;
        sc.nextLine();
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int k = sc.nextInt();
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            sc.nextLine();
            int x0 = sc.nextInt();
            int y0 = sc.nextInt();
            if (x != 0) {
                int num = 0;
                while (num < x) {
                    int tempY = n - x0 + 1;
                    x0 = y0;
                    y0 = tempY;
                    int temp = n;
                    n = m;
                    m = temp;
                    num++;
                }
            }
            if (y != 0) {
                y0 = m - y0 + 1;
            }
            if (z != 0) {
                int num = 0;
                while (num < z) {
                    int tempX = m - y0 + 1;
                    y0 = x0;
                    x0 = tempX;
                    int temp = n;
                    n = m;
                    m = temp;
                    num++;
                }
            }
            res[i][0] = x0;
            res[i][1] = y0;
        }

        for (int[] re : res) {
            System.out.println(re[0] + " " + re[1]);
        }
    }
}
