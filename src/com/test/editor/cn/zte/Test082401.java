package com.test.editor.cn.zte;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/8/24
 **/
public class Test082401 {
    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        // 正文
        int[] dp = new int[n + 1];
        int[] lenOfIndex = new int[n + 1];

        int max = arr[1];
        dp[1] = arr[1];
        lenOfIndex[1] = 1;

        for (int i = 2; i <= n; i++) {
            int val = (arr[i] + dp[i - 1] * lenOfIndex[i - 1]) / (lenOfIndex[i - 1] + 1);
            if (arr[i] > val) {
                dp[i] = arr[i];
                lenOfIndex[i] = 1;
            }else {
                dp[i] = val;
                lenOfIndex[i] = lenOfIndex[i - 1] + 1;
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
