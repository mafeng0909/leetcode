//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例：
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics 数组 双指针
// 👍 2330 👎 0

package com.leetcode.editor.cn;

import java.util.*;

/**
 * Java：三数之和
 *
 * @author mafeng
 */
public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution.threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> set = new HashSet<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                // 确保第一个元素不重复
//                if (i > 0 && nums[i] == nums[i - 1] && nums[i] > 0) {
//                    continue;
//                }
                int target = nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                if (nums[i] + nums[left] + nums[left + 1] > 0 || nums[i] + nums[right] + nums[right - 1] < 0) {
                    continue;
                }
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    // 保证 i 和 j 与第一个元素不重复被选择
                    if (sum + target > 0) {
                        right--;
                    } else if (sum + target < 0) {
                        left++;
                    } else if (sum + target == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(target);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        set.add(new ArrayList<>(list));
                        left++;
                        right--;
                    }
                }
            }
            return new ArrayList<>(set);
        }

        /**
         * 两数之和
         *
         * @param nums
         * @param first
         * @param result
         */
        public static void twoSum(int[] nums, int first, List<List<Integer>> result) {
            Set<List<Integer>> set = new HashSet<>();
            int target = nums[first];
            int i = first + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j];
                // 保证 i 和 j 与第一个元素不重复被选择
                if (sum + target > 0) {
                    j--;
                } else if (sum + target < 0) {
                    i++;
                } else if (sum + target == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(target);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    set.add(list);
                }
            }
            result.addAll(set);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
