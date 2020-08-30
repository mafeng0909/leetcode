//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 注意数组中可能存在重复的元素。 
//
// 示例 1： 
//
// 输入: [1,3,5]
//输出: 1 
//
// 示例 2： 
//
// 输入: [2,2,2,0,1]
//输出: 0 
//
// 说明： 
//
// 
// 这道题是 寻找旋转排序数组中的最小值 的延伸题目。 
// 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 170 👎 0


package com.leetcode.editor.cn;
/**
 * Java：寻找旋转排序数组中的最小值 II
 * 
 * @author: mafeng
 * @data: 2020-08-29 13:37:55
 **/
public class P154FindMinimumInRotatedSortedArrayIi{
    public static void main(String[] args) {
        Solution solution = new  Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < nums[right]) {
                    right = mid;
                }else if (nums[mid] > nums[right]) {
                    left = mid + 1;
                }else {
                    // 因为有重复元素，例：2 2 2 1 2 或 2 1 2 2 2
                    right--;
                }
            }
            return nums[left];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}