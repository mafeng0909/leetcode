//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// Related Topics 位运算 数组 回溯算法

package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：子集
 * @author mafeng
 */
public class P78Subsets{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        int[] nums = {1, 2};
        List<List<Integer>> list = solution.subsets(nums);
        System.out.println(list);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        // 方法一：递归加回溯
        public List<List<Integer>> subsets(int[] nums) {
            // 结果集
            List<List<Integer>> result = new ArrayList<>();
            // 产生的各子集集合
            List<Integer> item = new ArrayList<>();
            result.add(item);
            listAll(nums, 0, item, result);
            return result;
        }

        /**
         * 递归
         *
         * @param nums
         * @param index
         * @param item
         * @param result
         */
        public void listAll(int[] nums, int index, List<Integer> item, List<List<Integer>> result) {
            // 边界条件
            if (index == nums.length) {
                return;
            }
            for (int i = index; i < nums.length; i++) {
                // 转换方程
                item.add(nums[index]);
                result.add(new ArrayList<>(item));
                listAll(nums, index + 1, item, result);
                // 回溯
                item.remove(item.size() - 1);
            }
        }

        /**
         * dfs 递归 + 回溯
         *
         * @param nums
         * @param index
         * @param item
         * @param result
         */
        public void listAll2(int[] nums, int index, List<Integer> item, List<List<Integer>> result) {
            // 边界条件
            if (index == nums.length) {
                return;
            }
            // 转换方程
            item.add(nums[index]);
            result.add(new ArrayList<>(item));
            listAll(nums, index + 1, item, result);
            // 回溯
            item.remove(item.size() - 1);
            listAll(nums, index + 1, item, result);
        }

        // 方法二：位运算
        public List<List<Integer>> subsets2(int[] nums) {
            // 结果集
            List<List<Integer>> result = new ArrayList<>();
            // 排列组合总共的可能性
            int all = 1 << nums.length;
            for (int i = 0; i < all; i++) {
                // 产生的各子集集合
                List<Integer> item = new ArrayList<>();
                for (int j = 0; j < nums.length; j++) {
                    // 检测当前种类中，每种数字是否被选中，选中则加入到item中
                    int num = i & (1 << j);
                    if (num != 0) {
                        item.add(nums[j]);
                    }
                }
                result.add(item);
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
