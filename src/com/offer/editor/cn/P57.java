package com.offer.editor.cn;

/**
 * 题目：和为s的两个数字 -> 两数之和
 * 分析：双指针
 *      由于数组已经是排好序的了，所以直接双指针移动即可
 *
 * @author mafeng
 * @data 2020/7/25
 **/
public class P57 {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum > target) {
                end--;
            }else if (sum < target) {
                start++;
            }else {
                break;
            }
        }
        return new int[]{nums[start], nums[end]};
    }
}
