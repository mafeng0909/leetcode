//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 686 👎 0


package com.leetcode.editor.cn;
/**
 * Java：乘积最大子数组
 * 分析：动态规划
 *      原问题与子问题：
 *      状态：dp[i] 表示 以nums[i]结尾的乘积最大的子序列
 *          注：由于有的会有负数出现，所以我们也记录一下 以nums[i]结尾的乘积最小的子序列
 *      状态转换方程见代码
 * 
 * @author: mafeng
 * @data: 2020-08-02 21:24:41
 **/
public class P152MaximumProductSubarray{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int maxProduct(int[] nums) {
            // dp表示以nums[i]结尾的子序列的最大值和最小值
            int[] dpMax = new int[nums.length];
            int[] dpMin = new int[nums.length];
            int max = nums[0];
            dpMax[0] = nums[0];
            dpMin[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0) {
                    dpMax[i] = 0;
                    dpMin[i] = 0;
                }else if (nums[i] > 0) {
                    dpMax[i] = Math.max(nums[i], nums[i] * dpMax[i - 1]);
                    dpMin[i] = Math.min(nums[i], nums[i] * dpMin[i - 1]);
                }else {
                    dpMax[i] = Math.max(nums[i], nums[i] * dpMin[i - 1]);
                    dpMin[i] = Math.min(nums[i], nums[i] * dpMax[i - 1]);
                }
                max = Math.max(max, dpMax[i]);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}