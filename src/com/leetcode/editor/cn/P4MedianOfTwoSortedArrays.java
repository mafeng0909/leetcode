//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。 
//
// 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法

package com.leetcode.editor.cn;
/**
 * Java：寻找两个有序数组的中位数
 *
 * 由于数列是有序的，其实我们完全可以一半儿一半儿的排除。
 * 假设我们要找第 k 小数，我们可以每次循环排除掉 k/2 个数。
 *
 * @author mafeng
 */
public class P4MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        System.out.println(solution.findMedianSortedArrays(num1, num2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int sum = nums1.length + nums2.length;
            if (sum % 2 == 0) {
                return ((double) findKth(nums1, 0, nums2, 0, sum / 2) +
                        findKth(nums1, 0, nums2, 0, sum / 2 + 1)) / 2;
            }
            return findKth(nums1, 0, nums2, 0, (sum + 1) / 2);
        }

        private int findKth(int[] nums1, int left1, int[] nums2, int left2, int k) {
            // 边界条件
            // 1、当其中一数组长度为0，直接在另一个数组中取第k个数即可
            if (left1 >= nums1.length) {
                return nums2[left2 + k - 1];
            }
            if (left2 >= nums2.length) {
                return nums1[left1 + k - 1];
            }
            // 2、当k = 1时，直接比较两数组第一个数，取最小值
            if (k == 1) {
                return Math.min(nums1[left1], nums2[left2]);
            }
            int mid1 = left1 + k / 2 - 1 < nums1.length ? nums1[left1 + k / 2 - 1] : Integer.MAX_VALUE;
            int mid2 = left2 + k / 2 - 1 < nums2.length ? nums2[left2 + k / 2 - 1] : Integer.MAX_VALUE;
            if (mid1 <= mid2) {
                return findKth(nums1, left1 + k / 2, nums2, left2, k - k / 2);
            }
            return findKth(nums1, left1, nums2, left2 + k / 2, k - k / 2);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}