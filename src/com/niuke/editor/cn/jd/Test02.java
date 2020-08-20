package com.niuke.editor.cn.jd;

/**
 * 题目：上台阶
 * 分析：动态规划
 *      状态：dp[i] 代表 第 i级台阶的可能次数
 *      临界状态：dp[1] = 0, dp[1] = 1
 *      转换方程：dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007
 *
 * @author mafeng
 * @data 2020/8/18
 **/
public class Test02 {
    public static void main(String[] args) {

    }

    public int getInitial(int n) {
        // write code here
        if (n <= 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
