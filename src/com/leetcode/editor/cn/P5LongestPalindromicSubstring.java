//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

package com.leetcode.editor.cn;
/**
 * Java：最长回文子串
 * @author mafeng
 */
public class P5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        String s = solution.longestPalindrome("bb");
        System.out.println(s);
    }

    /**
     * 中心扩展方法
     */
    static class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }

            // 定义left和right来记录所查找的最长回文子串的前后索引
            int left = 0;
            int right = 0;
            for (int i = 0; i < s.length(); i++) {
                // 以中心向两端进行查找
                // 由于有奇偶之分，中心有一个数和两个数两种可能，例如：aba 或 abba
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                // 当前找到的长度大于之前已经找到的长度，则更新前后索引
                if (len > right - left) {
                    left = i - (len - 1) / 2;
                    right = i + len / 2;
                }
            }
            return s.substring(left, right + 1);
        }

        public int expandAroundCenter(String s, int left, int right) {
            int l = left;
            int r = right;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return r - l - 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}