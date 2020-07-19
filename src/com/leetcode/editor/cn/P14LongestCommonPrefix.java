//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串

package com.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Java：最长公共前缀
 * 方法：先排序，再比较第一个和最后一个元素的最长公共前缀
 *
 * @author mafeng
 */
public class P14LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            Arrays.sort(strs);
            String str1 = strs[0];
            String str2 = strs[strs.length - 1];
            int len = Math.min(str1.length(), str2.length());
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    break;
                }
                count++;
            }
            return str1.substring(0, count);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
