//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 
//
// 示例 1: 
//
// 输入: s = "egg", t = "add"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "foo", t = "bar"
//输出: false 
//
// 示例 3: 
//
// 输入: s = "paper", t = "title"
//输出: true 
//
// 说明: 
//你可以假设 s 和 t 具有相同的长度。 
// Related Topics 哈希表 
// 👍 230 👎 0


package com.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Java：同构字符串
 * 
 * @author: mafeng
 * @data: 2020-08-24 15:35:57
 **/
public class P205IsomorphicStrings{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        // 第一种：直接定义链各个数组，同时进行标记
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] indexS = new int[128];
            int[] indexT = new int[128];
            for (int i = 0; i < s.length(); i++) {
                char charS = s.charAt(i);
                char charT = t.charAt(i);
                if (indexS[charS] != indexT[charT]) {
                    return false;
                }
                // 之所以是 1 + i，因为防止当i = 0时，标记位置的数和未标记位置的数还是相等
                indexS[charS] = 1 + i;
                indexT[charT] = 1 + i;
            }
            return true;
        }

        // 第二种：算出两个标记数组
        public boolean isIsomorphic2(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] mark1 = mark(s);
            int[] mark2 = mark(t);
            for (int i = 0; i < mark1.length; i++) {
                if (mark1[i] != mark2[i]) {
                    return false;
                }
            }
            return true;
        }

        public static int[] mark(String s) {
            // 标记字符串s：如果相等，则被标记为最开始（第一个元素）的索引，如果不相等则被标记为自己的索引
            int[] index = new int[s.length()];
            Arrays.fill(index, -1);
            for (int i = 0; i < s.length(); i++) {
                if (index[i] == -1) {
                    index[i] = i;
                    for (int j = i + 1; j < s.length(); j++) {
                        if (s.charAt(j) == s.charAt(i)) {
                            index[j] = i;
                        }
                    }
                }
            }
            return index;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}