//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划

package com.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Java：零钱兑换
 * 分析：动态规划算法
 *     1、原问题和子问题：原问题 为 金额amount的最优解
 *                     子问题 为 金额1、金额2、... 、金额i的最优解
 *     2、状态：dp[i] 表示 金额 i 至少需要多少张零钱可以凑齐（最优解）
 *     3、临界状态：dp[0] = 0
 *     4、状态转换方程：dp[i] = min(dp[i], dp[i - coins[j]] + 1)
 *
 * @author mafeng
 */
public class P322CoinChange{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            /*int max = amount + 1;
            Arrays.fill(dp, max);*/
            Arrays.fill(dp, -1);
            // 临界条件
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    /*if (coin <= i) {
                        // 状态转换方程
                        dp[i] = Integer.min(dp[i], dp[i - coin] + 1);
                    }*/
                    if (i - coin >= 0 && dp[i - coin] != -1) {
                        if (dp[i] == -1 || dp[i] > dp[i - coin] + 1) {
                            dp[i] = dp[i - coin] + 1;
                        }
                    }
                }
            }
            /*return dp[amount] > amount ? -1 : dp[amount];*/
            return dp[amount];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}