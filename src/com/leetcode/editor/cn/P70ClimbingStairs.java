//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划

package com.leetcode.editor.cn;

/**
 * Java：爬楼梯
 * 分析：动态规划方法
 *     1、原问题与子问题：原问题为 求 n 级台阶有多少种走法
 *                     子问题为 求 1级台阶、2级台阶、... 、i级台阶有多少种走法
 *     2、状态：第 i 个状态，即第 i 级台阶的所有走法
 *     3、临界状态：dp[1] = 1; dp[2] = 2;
 *     4、状态转换方程：dp[i] = dp[i - 1] + dp[i - 2];
 *
 * @author mafeng
 */
public class P70ClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int climbStairs(int n) {
            /*// 1、回溯法 会超出时间限制
            if (n == 1 || n == 2) {
                return n;
            }
            return climbStairs(n - 1) + climbStairs(n - 2);*/

            // 2、动态规划
            if (n == 1) {
                return 1;
            }
            int[] dp = new int[n + 1];
            // 临界条件
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                // 状态转换方程
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}