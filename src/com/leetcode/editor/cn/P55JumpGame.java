//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组

package com.leetcode.editor.cn;

import java.util.ArrayList;

/**
 * Java：跳跃游戏
 * @author mafeng
 */
public class P55JumpGame{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public boolean canJump(int[] nums) {
            // 定义一个list来保存每个索引位置能够达到的最远距离
            ArrayList<Integer> indexMaxJump = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                indexMaxJump.add(i + nums[i]);
            }
            // 此时能达到的最远索引
            int maxIndex = 0;
            // 遍历索引
            int index = 0;
            // index < indexMaxJump.size()条件：遍历索引不能超过当前能到达的最远距离
            while (index <= maxIndex && index < indexMaxJump.size() && maxIndex < indexMaxJump.size()) {
                if (indexMaxJump.get(index) > maxIndex) {
                    maxIndex = indexMaxJump.get(index);
                }
                index++;
            }
            return index == indexMaxJump.size() || maxIndex >= indexMaxJump.size();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}