//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。
//
// 说明：
//
//
// 所有数字（包括 target）都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1:
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
//
//
// 示例 2:
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
// Related Topics 数组 回溯算法

package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Java：组合总和
 * 分析：递归 + 回溯 + 剪枝
 *      由于每个元素可以不限选择次数，所以我们选择在for循环中加 递归
 *      1、边界条件：当sum等于target时，我们直接将list加入进结果集
 *      2、剪枝条件：当sum大于target，直接退出
 *
 * @author mafeng
 */
public class P39CombinationSum{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> item = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(candidates, target, 0, 0, item, result);
            return result;
        }

        public void dfs(int[] candidates, int target, int sum, int index, List<Integer> item, List<List<Integer>> result) {
            // 边界条件
            if (sum == target) {
                result.add(new ArrayList<>(item));
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                if (sum + candidates[i] > target) {
                    // 由于已经排过序，后面的数比现在的数更大，所以更不可能成立
                    // 剪枝
                    break;
                }
                item.add(candidates[i]);
                dfs(candidates, target, sum + candidates[i], i, item, result);
                // 回溯
                item.remove(item.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
