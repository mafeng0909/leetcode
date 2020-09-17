package com.test.editor.cn.baidu;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/3
 **/
public class Test090302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] prices = new int[n];
        int[] weights = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            prices[i] = sc.nextInt();
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }

        int[] dp = new int[m + 1];
        int[] count = new int[m + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果重量在允许范围内
                if (i >= weights[j]) {
                    // 先将count置1
                    count[i] = 1;
                    int newNum = dp[i - weights[j]] + prices[j];
                    if (k >= newNum) {
                        if (count[i] < count[j] + 1) {
                            dp[i] = newNum;
                            count[i] = count[j] + 1;
                        }
                    }else {
                        dp[i] = Math.max(dp[i], dp[i - 1]);
                        count[i] = Math.max(count[i], count[i - 1]);
                    }
                    max = Math.max(max, count[i]);
                }
            }
        }
        System.out.println(max);
    }
}
