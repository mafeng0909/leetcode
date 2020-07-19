//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2: 
//
// 输入: [2,7,9,3,1]
//输出: 12
//解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
// Related Topics 动态规划

package com.leetcode.editor.cn;

/**
 * Java：打家劫舍
 * 分析：动态规划方法
 *      1、原问题与子问题：原问题为 求 n 个房间的最优解
 *                      子问题为 求 前 1个房间、前 2个房间、... 、前 i个房间的最优解
 *      2、状态：第 i 个状态，即前 i 个房间的最优解
 *      3、临界状态：dp[0] = num[0]; dp[1] = max(num[0], num[1]);
 *      4、状态转换方程：dp[i] = max(dp[i - 1], dp[i - 2] + num[i]);
 *
 * @author mafeng
 */
public class P198HouseRobber{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int[] dp = new int[nums.length];
            // 临界条件
            dp[0] = nums[0];
            dp[1] = Integer.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                // 状态转换方程
                dp[i] = Integer.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            return dp[nums.length - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}