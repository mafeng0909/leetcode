//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表

package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Java：单词规律
 * @author mafeng
 */
public class P290WordPattern{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public boolean wordPattern(String pattern, String str) {
            String[] strings = str.split(" ");
            HashMap<String, Character> hashMap = new HashMap<>(strings.length);
            ArrayList<Character> characters = new ArrayList<>();
            int index = 0;
            for (String string : strings) {
                // 如果 pattern的长度 是否 比str的长度 短
                if (index >= pattern.length()) {
                    return false;
                }
                // 看map中是否已经存在该字符串
                if (!hashMap.containsKey(string)) {
                    // 如果不存在
                    char c = pattern.charAt(index);
                    // 如果该字符串对应的字符已经使用过，返回false
                    if (characters.contains(c)) {
                        return false;
                    }
                    hashMap.put(string, c);
                    characters.add(c);
                }else {
                    Character character = hashMap.get(string);
                    if (character != pattern.charAt(index)) {
                        return false;
                    }
                }
                index++;
            }
            // 如果 pattern的长度 是否 比str的长度 长
            return index >= pattern.length();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}