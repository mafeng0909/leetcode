//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
// 说明：
//
//
// 拆分时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。
//
//
// 示例 1：
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//
//
// 示例 2：
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
//
//
// 示例 3：
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
//
// Related Topics 动态规划
// 👍 558 👎 0

package com.leetcode.editor.cn;

import java.util.List;

/**
 * Java：单词拆分
 * 分析：如果采用dfs会超时，因为不好剪枝
 *      采用动态规划
 *         1、原问题与子问题：
 *         2、状态：dp[i] 表示 从 0 到 i-1 的字符串是否可以被成功拆分
 *         3、临界条件：由于空字符串也是符合条件的，所以 dp[0] = true
 *         4、状态转换方程：
 *
 * @author mafeng
 */
public class P139WordBreak{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int sLen = s.length();
            int maxLen = 0;
            int minLen = Integer.MAX_VALUE;
            // 求出wordDict中字符串的长度范围，便于过滤
            for (String word : wordDict) {
                maxLen = Math.max(maxLen, word.length());
                minLen = Math.min(minLen, word.length());
            }

            boolean[] dp = new boolean[sLen + 1];
            // 临界条件
            dp[0] = true;
            for (int i = 1; i <= sLen; ++i) {
                // j是指s字符串的索引，增加minLen用来过滤
                for (int j = i - minLen; j >= 0 && i - j <= maxLen; --j) {
                    if (dp[j] && wordDict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[sLen];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
