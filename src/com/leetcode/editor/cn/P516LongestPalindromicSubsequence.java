//给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
//
//
//
// 示例 1:
//输入:
//
// "bbbab"
//
//
// 输出:
//
// 4
//
//
// 一个可能的最长回文子序列为 "bbbb"。
//
// 示例 2:
//输入:
//
// "cbbd"
//
//
// 输出:
//
// 2
//
//
// 一个可能的最长回文子序列为 "bb"。
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 只包含小写英文字母
//
// Related Topics 动态规划

package com.leetcode.editor.cn;
/**
 * Java：最长回文子序列
 * 分析：动态规划
 *      1、原问题与子问题：由于是回文，所以外层两个元素要相等，因此我们可以将问题转化为：
 *                     原问题为 求 0~(len-1) 内最长回文子序列
 *                     子问题为 求 0~(len-2)、1~(len-1) 或 1~(len-2)。。。i~j内最长回文子序列
 *      2、状态：dp[i][j]表示 i~j内最长回文子序列
 *      3、边界状态：dp[i][i] = 1
 *      4、状态转换方程：当s.charAt(i) == s.charAt(j), dp[i][j] = dp[i + 1][j - 1] + 2
 *                    当s.charAt(i) != s.charAt(j), dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
 *      注意：这种是大套小问题，所以，尽量先算小的，这样大的可以利用，以免多算
 * @author mafeng
 */
public class P516LongestPalindromicSubsequence{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int longestPalindromeSubseq(String s) {
            int len = s.length();
            int[][] dp = new int[len][len];
            for (int i = len - 1; i >= 0; i--) {
                // 边界条件
                dp[i][i] = 1;
                for (int j = i + 1; j < len; j++) {
                    // 状态转换方程
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
            }
            return dp[0][len - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
