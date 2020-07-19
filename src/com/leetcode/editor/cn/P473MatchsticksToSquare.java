//还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴
//都要用到。 
//
// 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。 
//
// 示例 1: 
//
// 
//输入: [1,1,2,2,2]
//输出: true
//
//解释: 能拼成一个边长为2的正方形，每边两根火柴。
// 
//
// 示例 2: 
//
// 
//输入: [3,3,3,3,4]
//输出: false
//
//解释: 不能用所有火柴拼成一个正方形。
// 
//
// 注意: 
//
// 
// 给定的火柴长度和在 0 到 10^9之间。 
// 火柴数组的长度不超过15。 
// 
// Related Topics 深度优先搜索

package com.leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Java：火柴拼正方形
 * 分析：1、将所有数求和，判断 sum % 4是否为0；
 *      2、对数组进行排序，从大到小 => 减少回溯的次数
 *      3、利用深度优先搜索将每个边放进桶中(dfs + 递归 + 回溯)
 *
 * @author mafeng
 */
public class P473MatchsticksToSquare{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public boolean makesquare(int[] nums) {
            if (nums.length < 4) {
                return false;
            }
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            // 判断总长度是否满足要求
            if (sum % 4 != 0) {
                return false;
            }
            int target = sum / 4;
            // 排序
//            int[] sortNums = sort(nums);
            Arrays.sort(nums);
            // 定义四个桶
            int[] bucket = new int[4];
//            return generate(0, sortNums, target, bucket);
            return generate(nums.length - 1, nums, target, bucket);
        }

        /**
         * dfs
         * @param index 搜索的索引
         * @param nums
         * @param target
         * @param bucket
         * @return
         */
        public boolean generate(int index, int[] nums, int target, int[] bucket) {
            // 边界条件
//            if (index >= nums.length) {
//                for (int sum : bucket) {
//                    if (sum != target) {
//                        return false;
//                    }
//                }
//                return true;
//            }
            if (index < 0) {
                for (int sum : bucket) {
                    if (sum != target) {
                        return false;
                    }
                }
                return true;
            }
            // 遍历4个桶，检验当前火柴可以放入哪个桶
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] + nums[index] > target) {
                    continue;
                }
                bucket[i] += nums[index];
                // 递归
//                if (generate(index + 1, nums, target, bucket)) {
//                    return true;
//                }
                if (generate(index - 1, nums, target, bucket)) {
                    return true;
                }
                // 回溯
                bucket[i] -= nums[index];
            }
            return false;
        }

        /**
         * 堆排序 从大到小
         * @param arr
         * @return
         */
        public int[] sort(int[] arr) {
            Queue<Integer> queue = new PriorityQueue<>((n1, n2) -> n2 - n1);
            for (int i : arr) {
                queue.add(i);
            }
            int[] nums = new int[arr.length];
            int index = 0;
            while (!queue.isEmpty()) {
                nums[index] = queue.poll();
                index++;
            }
            return nums;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}