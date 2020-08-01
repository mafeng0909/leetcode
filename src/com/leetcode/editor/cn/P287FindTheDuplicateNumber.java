//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出
//这个重复的数。 
//
// 示例 1: 
//
// 输入: [1,3,4,2,2]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [3,1,3,4,2]
//输出: 3
// 
//
// 说明： 
//
// 
// 不能更改原数组（假设数组是只读的）。 
// 只能使用额外的 O(1) 的空间。 
// 时间复杂度小于 O(n^2) 。
// 数组中只有一个重复的数字，但它可能不止重复出现一次。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 791 👎 0


package com.leetcode.editor.cn;

/**
 * Java：寻找重复数
 * 分析：二分查找
 *      由于有 n + 1个数，并且都在 1~n 之间，只有一个重复的说明 1~n每个数都有
 *      我们首先对数组进行遍历，然后统计出在mid~n之间数的出现次数，
 *      如果出现次数 > n - mid ；说明重复的数就在mid~n之间
 *      否则，就在1~mid之间
 * 
 * @author: mafeng
 * @data: 2020-08-01 16:53:43
 **/
public class P287FindTheDuplicateNumber{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        /**
         * 二分查找
         *
         * @param nums
         * @return
         */
        public int findDuplicate(int[] nums) {
            int left = 1;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 因为每次都要重新统计，所以直接在里面定义变量
//                int countLeft = 0;
                int countRight = 0;
                for (int num : nums) {
                    if (mid < num && num <= right) {
                        countRight++;
                    }/*else if (left <= num && num <= mid) {
                        countLeft++;
                    }*/
                }
                if (countRight > right - mid) {
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            return left;
        }

        /**
         * 快慢指针
         * 类似 寻找链表环入口
         *
         * @param nums
         * @return
         */
        public int findDuplicate2(int[] nums) {
            int fast = 0;
            int slow = 0;
            while (true) {
                // 快慢指针，一个每次走两步，一个每次走一步
                fast = nums[nums[fast]];
                slow = nums[slow];
                // 如果两个指针相遇了，将fast置为0，两指针再一起向前移动，相等即为入口
                if (fast == slow) {
                    fast = 0;
                    while (fast != slow) {
                        fast = nums[fast];
                        slow = nums[slow];
                    }
                    return slow;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}