//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 479 👎 0


package com.leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Java：滑动窗口最大值
 * 分析：维护一个k个数的最大堆
 * 
 * @author: mafeng
 * @data: 2020-08-02 22:17:09
 **/
public class P239SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (k <= 0) {
                return new int[nums.length];
            }
            int[] res = new int[nums.length - k + 1];
            Queue<Integer> maxK = new PriorityQueue<>((n1, n2) -> n2 - n1);
            for (int i = 0; i < nums.length; i++) {
                maxK.add(nums[i]);
                if (maxK.size() == k) {
                    res[i - k + 1] = maxK.peek();
                    maxK.remove(nums[i - k + 1]);
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}