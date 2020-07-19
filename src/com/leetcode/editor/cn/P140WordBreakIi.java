//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的
//句子。
//
// 说明：
//
//
// 分隔时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。
//
//
// 示例 1：
//
// 输入:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//输出:
//[
//  "cats and dog",
//  "cat sand dog"
//]
//
//
// 示例 2：
//
// 输入:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//输出:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//解释: 注意你可以重复使用字典中的单词。
//
//
// 示例 3：
//
// 输入:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出:
//[]
//
// Related Topics 动态规划 回溯算法
// 👍 190 👎 0

package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Java：单词拆分 II
 * 分析：采用动态规划
 *         1、原问题与子问题：
 *         2、状态：dp[i] 表示 从 0 到 i-1 的字符串是否可以被成功拆分
 *         3、临界条件：由于空字符串也是符合条件的，所以 dp[0] = true
 *         4、状态转换方程：
 *      每次我都将相应字符串存入一个list中
 *
 * @author mafeng
 */
public class P140WordBreakIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            int sLen = s.length();
            int maxLen = 0;
            int minLen = Integer.MAX_VALUE;
            // 求出wordDict中字符串的长度范围，便于过滤
            for (String word : wordDict) {
                maxLen = Math.max(maxLen, word.length());
                minLen = Math.min(minLen, word.length());
            }

            HashMap<Integer, List<String>> map = new HashMap<>(sLen + 1);
            for (int i = 0; i <= sLen; i++) {
                map.put(i, new ArrayList<>());
            }
            map.get(0).add("");
            boolean[] dp = new boolean[sLen + 1];
            // 临界条件
            dp[0] = true;
            for (int i = 1; i <= sLen; ++i) {
                // j是指s字符串的索引，增加minLen用来过滤
                for (int j = i - minLen; j >= 0 && i - j <= maxLen; --j) {
                    if (dp[j] && wordDict.contains(s.substring(j, i))) {
                        String str = "";
                        if (j == 0) {
                            str = s.substring(j, i);
                            map.get(i).add(str);

                        }else {
                            for (String s1 : map.get(j)) {
                                str = s1 + " " + s.substring(j, i);
                                map.get(i).add(str);

                            }
                        }
                        dp[i] = true;
                    }
                }
            }
            return map.get(sLen);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
