//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用一次。
//
// 说明：
//
//
// 所有数字（包括目标数）都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1:
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
//
//
// 示例 2:
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//]
// Related Topics 数组 回溯算法

package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Java：组合总和 II
 * 分析：递归 + 回溯 + 剪枝
 *      由于每个元素只能选择一次，所以每个元素都是只有两种状态，即选中或者不选中
 *      可以归结为一个二叉树的遍历
 *      1、临界条件：索引值不能越界
 *      2、剪枝条件：当sum大于target，直接退出，即break
 *                 如果上一个元素与当前元素相等，也需要进行小剪枝，即continue
 *
 * @author mafeng
 */
public class P40CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            ArrayList<Integer> item = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(candidates, target, 0, 0, item, result);
            return result;
        }

        public void dfs(int[] candidates, int target, int index, int sum, ArrayList<Integer> item, List<List<Integer>> result) {
            // 临界条件
            if (sum == target) {
                result.add(new ArrayList<>(item));
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                // 剪枝
                if (sum + candidates[i] > target) {
                    break;
                }
                // i > index确保上一个元素已经进行了遍历
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                item.add(candidates[i]);
                // 由于每个元素只能选择一次，所以我们的索引值i需要加1
                dfs(candidates, target, i + 1, sum + candidates[i], item, result);
                // 回溯
                item.remove(item.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
