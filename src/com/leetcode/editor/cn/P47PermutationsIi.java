//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法

package com.leetcode.editor.cn;

import java.util.*;

/**
 * Java：全排列 II
 * 方法：dfs + 剪枝 + 排序
 * @author mafeng
 */
public class P47PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {

            // 排序（升序或者降序都可以），排序是剪枝的前提
            Arrays.sort(nums);

            Deque<Integer> deque = new LinkedList<>();
            boolean[] isUsed = new boolean[nums.length];
            LinkedList<List<Integer>> output = new LinkedList<>();
            dfs(nums, output, deque, isUsed, 0);
            return output;
        }

        private void dfs(int[] nums, List<List<Integer>> output,
                         Deque<Integer> deque, boolean[] isUsed, int index) {
            if (index >= nums.length) {
                output.add(new ArrayList<>(deque));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (isUsed[i]) {
                    continue;
                }
                // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
                // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
                if (i > 0 && nums[i] == nums[i - 1] && isUsed[i - 1] == false) {
                    continue;
                }
                deque.addLast(nums[i]);
                isUsed[i] = true;
                dfs(nums, output, deque, isUsed, index + 1);
                deque.removeLast();
                isUsed[i] = false;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}