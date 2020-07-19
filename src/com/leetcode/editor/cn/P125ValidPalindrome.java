//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串

package com.leetcode.editor.cn;
/**
 * Java：验证回文串
 * @author mafeng
 */
public class P125ValidPalindrome{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public boolean isPalindrome(String s) {
            if (s.length() <= 1) {
                return true;
            }
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                // 判断左边字符是否是数字或者字母
                if (!Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                    // 判断右边字符是否是数字或者字母
                }else if (!Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                }else {
                    // 忽略大小写进行判断是否相等
                    if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                        return false;
                    }
                    left++;
                    right--;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
