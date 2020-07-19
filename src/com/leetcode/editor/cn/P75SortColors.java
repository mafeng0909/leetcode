//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
// 注意:
//不能使用代码库中的排序函数来解决这道题。
//
// 示例:
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2]
//
// 进阶：
//
//
// 一个直观的解决方案是使用计数排序的两趟扫描算法。
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
// 你能想出一个仅使用常数空间的一趟扫描算法吗？
//
// Related Topics 排序 数组 双指针
// 👍 481 👎 0

package com.leetcode.editor.cn;

/**
 * Java：颜色分类
 * 分析：有三种颜色，所以我们使用三个索引来实现只遍历一遍
 *
 * @author mafeng
 */
public class P75SortColors{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public void sortColors(int[] nums) {
            // two索引代表 2 的交换索引
            int two = nums.length;
            // zero索引代表 0 的交换索引
            int zero = -1;
            // 保证 i 小于 two 这个索引
            for (int i = 0; i < two; ) {
                if (nums[i] == 1) {
                    i++;
                }else if (nums[i] == 2) {
                    two--;
                    swap(nums, i, two);
                }else {
                    zero++;
                    swap(nums, zero, i);
                    i++;
                }
            }
        }

        public static void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
