//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 112 👎 0


package com.leetcode.editor.cn;

/**
 * Java：反转字符串中的元音字母
 *
 * @author: mafeng
 * @data: 2020-09-07 22:45:14
 **/
public class P345ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public String reverseVowels(String s) {
            char[] chars = s.toCharArray();
            int left = 0;
            int right = chars.length - 1;
            while(left < right) {
                // 找到左指针的第一个元音字母
                while(!judge(chars[left]) && left < chars.length - 1) {
                    left++;
                }
                // 找到右指针的第一个元音字母
                while(!judge(chars[right]) && 0 < right) {
                    right--;
                }
                if(left >= right) {
                    break;
                }
                char c = chars[left];
                chars[left] = chars[right];
                chars[right] = c;
                left++;
                right--;
            }
            return new String(chars);
        }

        public static boolean judge(char c) {
            char[] chars = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
            for (char aChar : chars) {
                if (c == aChar) {
                    return true;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}