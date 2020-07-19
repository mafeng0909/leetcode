//所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究
//非常有帮助。 
//
// 编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。 
//
// 
//
// 示例： 
//
// 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC", "CCCCCAAAAA"] 
// Related Topics 位运算 哈希表

package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Java：重复的DNA序列
 * @author mafeng
 */
public class P187RepeatedDnaSequences{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> list = solution.findRepeatedDnaSequences(s);
        for (String str : list) {
            System.out.println(str);
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {

        // 第一种：hashmap
        public List<String> findRepeatedDnaSequences(String s) {
            int len = 10;
            HashMap<String, Integer> map = new HashMap<>(s.length());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < s.length() - len + 1; i++) {
                String substring = s.substring(i, i + len);
                if (!map.containsKey(substring)) {
                    map.put(substring, 1);
                }else {
                    Integer integer = map.get(substring);
                    map.replace(substring, integer, integer + 1);
                    if (!list.contains(substring)) {
                        list.add(substring);
                    }
                }
            }
            return list;
        }

        // 第二种：编码
        public List<String> findRepeatedDnaSequences2(String s) {
            int length = s.length();
            int len = 10;
            if (length < len) {
                return new ArrayList<>();
            }

            // 定义一个数组存储字符串编码后出现的次数
            int a = 2;
            int num = (int) Math.pow(a, a * len);
            int[] numsTimes = new int[num];

            // 将字符转换为数字 编码规则
            HashMap<Character, Integer> map = new HashMap<>(4);
            map.put('A', 0);
            map.put('C', 1);
            map.put('G', 2);
            map.put('T', 3);

            int[] nums = new int[length];
            for (int i = 0; i < length; i++) {
                nums[i] = map.get(s.charAt(i));
            }

            // 定义一个集合存储结果
            List<String> result = new ArrayList<>();
            int bitmask = 0;

            for (int start = 0; start < length - len + 1; start++) {
                if (start == 0) {
                    for (int i = 0; i < len; i++) {
                        // 左移以释放最后两位
                        bitmask <<= 2;
                        // 添加 num[i] 到最后两位(二进制)
                        bitmask |= nums[i];
                    }
                }else {
                    bitmask <<= 2;
                    bitmask |= nums[start + len - 1];
                    // 去掉最前面两位
                    bitmask &= ~(3 << a * len);
                }
                numsTimes[bitmask]++;
                if (numsTimes[bitmask] > 1 ) {
                    String substring = s.substring(start, start + len);
                    if (!result.contains(substring)) {
                        result.add(substring);
                    }
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}