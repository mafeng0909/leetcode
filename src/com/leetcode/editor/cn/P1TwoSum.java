//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表

package com.leetcode.editor.cn;

import java.util.HashMap;

/**
 * Java：两数之和
 * 分析：此题不能用双指针，因为此题没说数组是有序的，并且返回的是索引位置
 *
 * @author mafeng
 */
public class P1TwoSum{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST

    }

    /**
     * 暴力破解
     * 优化：可以利用哈希来减少时间复杂度（即加快查找速度）
     */
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            // 1、暴力破解
            /*int[] index = new int[2];
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        index[0] = i;
                        index[1] = j;
                        return index;
                    }
                }
            }
            return index;*/

            // 2、利用哈希来加快查找速度
            HashMap<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                int component = target - nums[i];
                if (map.containsKey(component)) {
                    return new int[]{map.get(component), i};
                }
                map.put(nums[i], i);
            }
            return new int[]{};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}