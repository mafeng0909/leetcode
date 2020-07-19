//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表

package com.leetcode.editor.cn;
/**
 * Java：最长回文串
 * 方法：采用哈希表 将每一个元素都映射进哈希表，进行统计字符个数，
 *      进而统计最长回文串
 *
 * @author mafeng
 */
public class P409LongestPalindrome{
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "adadaada";
        System.out.println(solution.longestPalindrome(s));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int longestPalindrome(String s) {
            int[] stringCount = new int[128];
            for (char c : s.toCharArray()) {
                stringCount[c]++;
            }
            // 记录长度
            int count = 0;
            // 记录奇偶
            int flag = 0;
            for (int value : stringCount) {
                if (value == 0) {
                    continue;
                }
                if (value % 2 == 0) {
                    count += value;
                } else {
                    count += value - 1;
                    flag = 1;
                }
            }
            return flag == 1 ? count + 1 : count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}