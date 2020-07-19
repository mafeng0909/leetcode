//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
// Related Topics 数组 回溯算法

package com.leetcode.editor.cn;

import java.util.*;

/**
 * Java：子集 II
 * 方法：由于顺序不同会导致有重复，所以我们先对数组进行排序，然后甩set来检查重复
 *       属于二叉树范畴
 *
 * @author mafeng
 */
public class P90SubsetsIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            // 结果集
            Set<List<Integer>> result = new HashSet<>();
            List<Integer> item = new ArrayList<>();
            result.add(item);
            Arrays.sort(nums);
            allList(nums, 0, item, result);
            return new ArrayList<>(result);
        }

        public void allList(int[] nums, int index, List<Integer> item, Set<List<Integer>> result) {
            // 临界条件
            if (index == nums.length) {
                return;
            }
            item.add(nums[index]);
            result.add(new ArrayList<>(item));
            // 对左边进行递归
            allList(nums, index + 1, item, result);
            // 回溯
            item.remove(item.size() - 1);
            // 对右边进行递归
            allList(nums, index + 1, item, result);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
