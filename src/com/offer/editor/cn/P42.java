package com.offer.editor.cn;

/**
 * @author mafeng
 * 题目：连续子数组的最大和
 * 分析：动态规划
 *      1 原问题与子问题：子问题是以nums[i]结尾的最大字段和
 *      2 状态：dp[i] 表示 以nums[i]结尾的最大字段和
 *      3 临界状态：dp[0] = nums[0]
 *      4 状态转换方程：dp[i] = max(dp[i - 1] + nums[i], nums[i])
 *
 * @data 2020/7/21
 **/
public class P42 {
    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        // 临界条件
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            // 状态转换方程
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
