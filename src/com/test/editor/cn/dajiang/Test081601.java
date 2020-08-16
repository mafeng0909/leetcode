package com.test.editor.cn.dajiang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/8/16
 **/
public class Test081601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        sc.nextLine();
        int[] achievement = new int[n];
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            achievement[i] = sc.nextInt();
            days[i] = sc.nextInt();
            sc.nextLine();
        }
        // 花费i天所能达到的最大价值
        int[] dp = new int[x + 1];

        Arrays.fill(dp, 0);
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < days.length; j++) {
                if (days[j] <= i) {
                    dp[i] = Math.max(dp[i], achievement[j] + dp[i - days[j]]);
                }
            }
        }
        System.out.println(dp[x]);

    }
}
