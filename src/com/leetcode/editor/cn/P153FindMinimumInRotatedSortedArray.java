//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 你可以假设数组中不存在重复元素。 
//
// 示例 1: 
//
// 输入: [3,4,5,1,2]
//输出: 1 
//
// 示例 2: 
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0 
// Related Topics 数组 二分查找 
// 👍 225 👎 0


package com.leetcode.editor.cn;
/**
 * Java：寻找旋转排序数组中的最小值
 * 
 * @author: mafeng
 * @data: 2020-07-28 23:39:42
 **/
public class P153FindMinimumInRotatedSortedArray{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] < nums[right]) {
                    return nums[left];
                }
                int mid = left + (right - left) / 2;
                // 左边小于中位数，说明左边递增；相反说明右边是递增的
                if (nums[left] < nums[mid]) {
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            return nums[left];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}