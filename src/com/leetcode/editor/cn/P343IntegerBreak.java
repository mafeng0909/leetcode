//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。 
//
// 示例 1: 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。 
// Related Topics 数学 动态规划 
// 👍 257 👎 0


package com.leetcode.editor.cn;
/**
 * Java：整数拆分
 * 分析：1、动态规划
 *          原问题与子问题：
 *          状态：dp[i] 即 整数为i的最大拆分乘积
 *          临界状态：dp[1] = 1
 *          转换方程：dp[i] = Math.max(dp[i], Math.max(dp[i - j], i - j) * j);
 *
 *      2、数学方法
 *        https://leetcode-cn.com/problems/integer-break/solution/343-zheng-shu-chai-fen-tan-xin-by-jyd/
 *
 * @author: mafeng
 * @data: 2020-07-26 16:10:36
 **/
public class P343IntegerBreak{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int integerBreak(int n) {
            if(n <= 3) {
                return n - 1;
            }
            int a = n / 3;
            int b = n % 3;
            if(b == 0) {
                return (int)Math.pow(3, a);
            }
            if(b == 1) {
                return (int)Math.pow(3, a - 1) * 4;
            }
            return (int)Math.pow(3, a) * 2;
        }

        public int integerBreak2(int n) {
            if (n < 3) {
                return n - 1;
            }
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(dp[i - j], i - j) * j);
                }
            }
            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}