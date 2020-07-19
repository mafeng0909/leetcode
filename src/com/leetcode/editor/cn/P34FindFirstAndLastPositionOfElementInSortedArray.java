//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找

package com.leetcode.editor.cn;
/**
 * Java：在排序数组中查找元素的第一个和最后一个位置
 * @author mafeng
 */
public class P34FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = searchLeft(nums, target);
            int right = searchRight(nums, target);
            return new int[]{left, right};
        }

        public int searchLeft(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (target == nums[mid]) {
                    if (mid == left || target > nums[mid - 1]) {
                        return mid;
                    }
                    right = mid - 1;
                }else if (target > nums[mid]) {
                    left = mid + 1;
                }else if (target < nums[mid]) {
                    right = mid - 1;
                }
            }
            return -1;
        }

        public int searchRight(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (target == nums[mid]) {
                    if (mid == right || target < nums[mid + 1]) {
                        return mid;
                    }
                    left = mid + 1;
                }else if (target > nums[mid]) {
                    left = mid + 1;
                }else if (target < nums[mid]) {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}