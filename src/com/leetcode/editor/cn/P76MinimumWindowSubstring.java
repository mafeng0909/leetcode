//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。 
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

package com.leetcode.editor.cn;

/**
 * Java：最小覆盖子串
 * @author mafeng
 */
public class P76MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        // 滑动窗口
        public String minWindow(String s, String t) {
            int sLen = s.length();
            int tLen = t.length();
            if (sLen < tLen || sLen == 0 || tLen == 0) {
                return "";
            }

            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();

            int[] winFrq = new int[128];
            int[] tFrq = new int[128];

            // 记录字符集 t 的每个字符的出现频数
            for (char tChar : tChars) {
                tFrq[tChar]++;
            }
            // 记录窗口中包含 t字符集的个数
            int distance = 0;
            int minLen = sLen + 1;
            int beginIndex = 0;
            int left = 0;
            int right = 0;

            while (left <= right && right < sLen) {
                char sCharR = sChars[right];
                // 如果右指针所指向的元素在 t字符集中没有，我们继续右移
                if (tFrq[sCharR] == 0) {
                    right++;
                    continue;
                }

                // 只有当不超过该字符在 t 中出现的频数时，数量才 +1
                if (winFrq[sCharR] < tFrq[sCharR]) {
                    distance++;
                }
                // 记录在 t 中出现的字符及其出现的频数
                winFrq[sCharR]++;
                right++;

                // 当窗口中包含 t 中全部的字符时，我们再移动左指针
                while (distance == tLen) {
                    char sCharL = sChars[left];
                    if (tFrq[sCharL] == 0) {
                        left++;
                        continue;
                    }
                    // [beginIndex, beginIndex + minLen)
                    if (minLen > right - left) {
                        minLen = right - left;
                        beginIndex = left;
                    }

                    if (winFrq[sCharL] == tFrq[sCharL]) {
                        distance--;
                    }

                    winFrq[sCharL]--;
                    left++;
                }
            }
            if (minLen == sLen + 1) {
                return "";
            }
            return s.substring(beginIndex, beginIndex + minLen);

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}