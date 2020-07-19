//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

package com.leetcode.editor.cn;

import java.util.*;

/**
 * Java：全排列
 * @author mafeng
 */
public class P46Permutations{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            Deque<Integer> deque = new LinkedList<>();
            boolean[] isUsed = new boolean[nums.length];
            List<List<Integer>> output = new LinkedList<>();
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