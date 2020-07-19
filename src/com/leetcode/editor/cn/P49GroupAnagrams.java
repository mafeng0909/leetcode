//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串

package com.leetcode.editor.cn;

import java.util.*;

/**
 * Java：字母异位词分组
 * @author mafeng
 */
public class P49GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        String s = "asdfg";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        System.out.println(s);
        System.out.println(chars);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> hashMap = new HashMap<>(strs.length);
            for (String str : strs) {
                String sortString = sortString(str);
                // 查看是否是相同元素组成的字符串
                if (!hashMap.containsKey(sortString)) {
                    hashMap.put(sortString, new ArrayList<>());
                }
                hashMap.get(sortString).add(str);
            }
            // 整理结果
            return new ArrayList<>(hashMap.values());
        }

        public String sortString(String str) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return Arrays.toString(chars);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}