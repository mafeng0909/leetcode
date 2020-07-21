package com.test.editor.cn;

/**
 * @author mafeng
 * 动态规划：将原问题化为多个子问题，但是子问题之间都相互关联
 *         主要分析四点：1 原问题与子问题
 *                     2 状态
 *                     3 临界状态
 *                     4 状态转换方程
 *
 * @data 2020/7/21
 **/
public class P5DynamicProgrammingAlgorithm {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};
        int[] v = {1500, 3000, 2000};
        int target = 4;
        System.out.println(knapsackProblem(w, v, target));
    }

    /**
     * 01背包问题  -> 每个商品只有两种状态，装进去或者不装
     * 分析：1 原问题：n个商品能够装入容量为target的背包的最大价值
     *        子问题：前 i个商品能够装入容量为 j的背包的最大价值（i <= n ; j <= target）
     *      2 状态：dp[i][j] 表示 前 i个商品能够装入容量为j的背包的最大价值
     *      3 临界条件：dp[...][0]、dp[0][...] 均为0
     *      4 状态转换方程：
     *           当w[i] > j, dp[i][j] = dp[i - 1][j]
     *           当w[i] <= j, dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - v[i]] + v[i])
     *
     * @param weight
     * @param value
     * @param targetWeight
     * @return 最大的价值
     */
    public static int knapsackProblem(int[] weight, int[] value, int targetWeight) {
        int num = weight.length;
        int[][] dp = new int[num + 1][targetWeight + 1];

        // 现将临界条件进行填充
        for (int i = 0; i <= num; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= targetWeight; j++) {
            dp[0][j] = 0;
        }

        // 进行其他位置的填充
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= targetWeight; j++) {
                // 状态转换方程
                if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        return dp[num][targetWeight];
    }
}
