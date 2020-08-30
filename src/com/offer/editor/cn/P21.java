package com.offer.editor.cn;

/**
 * @author mafeng
 * @data 2020/8/30
 **/
public class P21 {
    public static void main(String[] args) {

    }

    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if ((nums[left] & 1) == 1) {
                left++;
                continue;
            }
            if ((nums[right] & 1) != 1) {
                right--;
                continue;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}
