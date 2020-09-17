package com.test.editor.cn.duoyinet;

import java.util.Arrays;

/**
 * @author mafeng
 * @data 2020/9/3
 **/
public class Test0903 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        func(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void func(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
