//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找

package com.leetcode.editor.cn;
/**
 * Java：搜索插入位置
 * @author mafeng
 */
public class P35SearchInsertPosition{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            /*for (int i = 0; i < nums.length; i++) {
                if (nums[i] > target) {
                    return i;
                }
            }
            return nums.length;*/

            int left = 0;
            int right = nums.length - 1;
            // 索引
            int index = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (target == nums[mid]) {
                    index = mid;
                }else if (target > nums[mid]) {
                    // 判断是否到达边界
                    if (mid == right || target < nums[mid + 1]) {
                        index = mid + 1;
                    }
                    left = mid + 1;
                }else if (target < nums[mid]) {
                    // 判断是否到达边界
                    if (mid == left || target > nums[mid - 1]) {
                        index = mid;
                    }
                    right = mid - 1;
                }
            }
            return index;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}