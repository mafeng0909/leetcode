//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 1514 👎 0


package com.leetcode.editor.cn;
/**
 * Java：接雨水
 * 分析：双指针
 *      分别记录下左边和右边的遍历时的最大值（maxLeft，maxRight）
 *      当height[left] < height[right]情况下，如果maxLeft > height[left], 便可以积水
 *                                           否则，更新maxLeft
 *      当height[left] >= height[right]情况下，如果maxRight > height[right], 便可以积水
 *                                           否则，更新maxRight
 * 
 * @author: mafeng
 * @data: 2020-08-05 23:54:09
 **/
public class P42TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int trap(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int maxLeft = 0;
            int maxRight = 0;

            int result = 0;
            while (left < right) {
                // 左边值比右边大
                if (height[left] < height[right]) {
                    if (maxLeft > height[left]) {
                        result += maxLeft - height[left];
                    } else {
                        maxLeft = height[left];
                    }
                    left++;
                } else {
                    if (maxRight > height[right]) {
                        result += maxRight - height[right];
                    } else {
                        maxRight = height[right];
                    }
                    right--;
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}