//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划

package com.leetcode.editor.cn;

/**
 * Java：最大子序和
 * 分析：动态规划算法
 *     原问题与子问题：原问题为 n个数所组成的最大子序和
 *                  子问题为 前 1个数、2个数、... 、i个数所组成的最大子序和
 *     状态：dp[i] 表示 第 i个状态为 以第i个数为结尾的最大子序和
 *     临界状态：dp[0] = nums[0]
 *     状态转换方程：dp[i] = max(dp[i - 1] + nums[i], nums[i])
 *              即 dp[i - 1] < 0, 就舍弃前面的数字段
 *                 否则，就加上之前的连续子段
 *
 * @author mafeng
 */
public class P53MaximumSubarray{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            // 临界条件
            dp[0] = nums[0];
            int maxSum = dp[0];
            for (int i = 1; i < nums.length; i++) {
                // 状态转换方程
                dp[i] = Integer.max(dp[i - 1] + nums[i], nums[i]);
                if (dp[i] > maxSum) {
                    maxSum = dp[i];
                }
            }
            return maxSum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}