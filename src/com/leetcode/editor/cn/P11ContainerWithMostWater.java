//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。
//
//
//
//
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
//
//
// 示例：
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49
// Related Topics 数组 双指针
// 👍 1591 👎 0

package com.leetcode.editor.cn;
/**
 * Java：盛最多水的容器
 * 分析：L = min(left, right) * (j - i)
 *      所以我们定义两个指针，一个在左，一个在右
 *      每次移动边长小的那一边
 *
 * @author mafeng
 */
public class P11ContainerWithMostWater{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int maxArea(int[] height) {
            int i = 0;
            int j = height.length - 1;
            int maxResult = 0;
            while (i < j) {
                maxResult = height[i] < height[j] ?
                        Math.max(maxResult, (j - i) * height[i++]) : Math.max(maxResult, (j - i) * height[j--]);
            }
            return maxResult;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
