//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
// '.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
//
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
//
// 说明:
//
//
// s 可能为空，且只包含从 a-z 的小写字母。
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
//
//
// 示例 1:
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
//
//
// 示例 2:
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
//
//
// 示例 3:
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
//
//
// 示例 4:
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
//
//
// 示例 5:
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false
// Related Topics 字符串 动态规划 回溯算法

package com.leetcode.editor.cn;
/**
 * Java：正则表达式匹配
 * 分析：题目中隐含条件：*不能在开头；*之前不能是*
 *
 *      动态规划
 *      原问题和子问题：
 *      状态：dp[i][j] 表示 s长度为i，p长度为j时，是否符合要求
 *      边界条件：dp[0][0] = true 即 两个串均为空串
 *      状态转换方程：
 *
 * @author mafeng
 */
public class P10RegularExpressionMatching{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public boolean isMatch(String s, String p) {
            // 判断 s 和 p 是否相等
            if (s.equals(p)) {
                return true;
            }

            char[] sChars = s.toCharArray();
            char[] pChars = p.toCharArray();

            int sLen = s.length();
            int pLen = p.length();
            boolean[][] dp = new boolean[sLen + 1][pLen + 1];
            dp[0][0] = true;

            for (int i = 1; i <= pChars.length; ++i) {
                // dp[0][i] = pChars[i - 1] == '*' ? dp[0][i - 2] : false;
                dp[0][i] = pChars[i - 1] == '*' && dp[0][i - 2];
            }

            for (int i = 1; i <= sChars.length; ++i) {
                for (int j = 1; j <= pChars.length; ++j) {
                    if (sChars[i - 1] == pChars[j - 1] || pChars[j -1] == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }else if (pChars[j - 1] == '*') {
                        dp[i][j] |= dp[i][j - 2];
                        if (sChars[i - 1] == pChars[j - 2] || pChars[j - 2] == '.') {
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }
            }
            return dp[sLen][pLen];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
