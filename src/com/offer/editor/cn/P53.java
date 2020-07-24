package com.offer.editor.cn;

/**
 * @author mafeng
 * 题目：在排序数组中查找数字 I
 *      统计一个数字在排序数组中出现的次数。
 * 分析：二分查找
 *      寻找 左端点和 右端点
 *
 * @data 2020/7/24
 **/
public class P53 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(search(nums, 7));
    }

    public static int search(int[] nums, int target) {
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        return left == -1 ? 0 : right - left + 1;
    }

    /**
     * 寻找左端点
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                // 如果mid已经到达最左边了，或者左边的元素都比target小，则mid就是左端点
                if (mid == left || nums[mid - 1] < target) {
                    return mid;
                }
                right = mid - 1;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 寻找右端点
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                // 如果mid已经到达最右边了，或者右边的元素都比target大，则mid就是右端点
                if (mid == right || nums[mid + 1] > target) {
                    return mid;
                }
                left = mid + 1;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}



