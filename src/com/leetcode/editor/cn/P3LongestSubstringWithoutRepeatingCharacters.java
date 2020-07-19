//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window

package com.leetcode.editor.cn;

/**
 * Java：无重复字符的最长子串
 * 分析：滑动窗口
 *
 * @author mafeng
 */
public class P3LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }

    /**
     * 滑动窗口算法
     */
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            // 1、用hashmap来做
            /*int ans = 0;
            Map<Character, Integer> map = new HashMap<>(s.length());
            //i代表left，j代表right，以right为循环
            for (int i = 0, j = 0; j < s.length(); j++) {
                if (map.containsKey(s.charAt(j))) {
                    // 如果有相同的字符，则将i替换成该字符第一次出现位置的后一位
                    i = Math.max(i, map.get(s.charAt(j)));
                }
                // 更新最大长度ans
                ans = Math.max(ans, j - i + 1);
                // 将j索引的字符加入到map
                map.put(s.charAt(j), j + 1);
            }*/

            // 2、用字符集来做
            int ans = 0;
            int[] index = new int[128];
            for (int i = 0, j = 0; j < s.length(); j++) {
                // 如果有相同的字符，则将i替换成该字符第一次出现位置的后一位
                i = Math.max(i, index[s.charAt(j)]);
                // 更新最大长度ans
                ans = Math.max(ans, j - i + 1);
                // 将j索引的字符加入到数组，并记录最新出现的索引位置的后一位
                index[s.charAt(j)] = j + 1;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
