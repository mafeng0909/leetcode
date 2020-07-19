//给定一个非负整数数组，你最初位于数组的第一个位置。 
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
// 示例: 
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
// 说明:
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组

package com.leetcode.editor.cn;
/**
 * Java：跳跃游戏 II
 * 方法：贪心法
 * @author mafeng
 */
public class P45JumpGameIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int jump(int[] nums) {
            if (nums.length < 2) {
                return 0;
            }
            // 当前能达到的最远索引位置
            int currentMaxIndex = nums[0];
            // 判断是否可以一步达到
            if (currentMaxIndex >= nums.length - 1) {
                return 1;
            }
            // 记录遍历时能到达的最远索引位置
            int maxIndex = nums[0];
            // 记录最少需要跳跃的次数
            int count = 0;
            for (int i = 1; i < nums.length; i++) {
                // 当遍历的索引超过当前所能达到的最远索引位置时，我们进行跳跃
                if (i > currentMaxIndex) {
                    count++;
                    currentMaxIndex = maxIndex;
                    // 当前所能到达的最远索引位置更新之后，判断能否加一步达到最后
                    if (currentMaxIndex >= nums.length - 1) {
                        break;
                    }
                }
                // 当遍历位置的所能到达的最远索引位置 大于 当前所能到达的最远索引位置，则更新
                if (maxIndex < nums[i] + i) {
                    maxIndex = nums[i] + i;
                }
            }
            return count + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}