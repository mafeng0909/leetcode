package com.test.editor.cn.shopee;

/**
 * @author mafeng
 * @data 2020/8/19
 **/
public class Test081903 {
    public static void main(String[] args) {

    }

    public static int func(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            int factor = factor(i);
            dp[i] = dp[i - 1] + dp[i - 1] * (int)Math.pow(2, -factor);
        }
        return dp[n];
    }

    public static int factor(int n) {
        int count = 0;
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }
}
