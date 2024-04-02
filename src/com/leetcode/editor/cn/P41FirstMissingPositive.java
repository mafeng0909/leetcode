//给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,0]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [3,4,-1,1]
//输出: 2
// 
//
// 示例 3: 
//
// 输入: [7,8,9,11,12]
//输出: 1
// 
//
// 
//
// 提示： 
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。 
// Related Topics 数组 
// 👍 798 👎 0


package com.leetcode.editor.cn;

import java.util.HashSet;

/**
 * Java：缺失的第一个正数
 * 
 * @author: mafeng
 * @data: 2020-09-25 09:42:35
 **/
public class P41FirstMissingPositive{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int firstMissingPositive(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            int len = nums.length;
            for (int num : nums) {
                if (num < 0) {
                    set.add(len + 1);
                }else {
                    set.add(num);
                }
            }
            for (int i = 1; i <= len; i++) {
                boolean flag = set.add(i);
                if (flag) {
                    return i;
                }
            }
            return len + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}