//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划

package com.leetcode.editor.cn;

import java.util.ArrayList;

/**
 * Java：最长上升子序列
 * 分析：
 * 方法一：动态规划算法
 *      1、原问题和子问题：
 *      2、状态：dp[i] 即 以 nums[i]为结尾的最长上升子序列
 *      3、临界状态：dp[0] = 1
 *      4、状态转换方程：在 j < i, num[j] < num[i]的情况下，
 *                     dp[i] = dp[j] + 1;
 * 方法二：用一个栈（arraylist表示）
 *      遍历数组，将其与栈顶元素进行比较
 *      1、nums[i] > 栈顶元素，直接将其添加到栈顶
 *      2、nums[i] <= 栈顶元素，遍历栈中的元素，当找到第一个比nums[i]大（或者等于）的数，
 *         将其替换成nums[i]
 *
 * @author mafeng
 */
public class P300LongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        // 方法一
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            int max = 1;
            // 临界状态
            dp[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                // 防止num[i]是最小的一个
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    // 状态转换方程
                    if (nums[j] < nums[i] && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
            return max;
        }

        // 方法二
        public int lengthOfLIS2(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            ArrayList<Integer> stack = new ArrayList<>();
            stack.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                if (stack.get(stack.size() - 1) < nums[i]) {
                    stack.add(nums[i]);
                }else {
                    for (int j = 0; j < stack.size(); j++) {
                        if (stack.get(j) >= nums[i]) {
                            stack.set(j, nums[i]);
                            break;
                        }
                    }
                }
            }
            return stack.size();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}