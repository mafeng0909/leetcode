//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 684 👎 0


package com.leetcode.editor.cn;
/**
 * Java：多数元素
 * 分析：由于多数元素是指出现次数大于n/2的元素，所以相当于每两个元素中就有一个是该元素
 *      所以在遍历的时候，我们记录两个值，一个是count，一个是target
 *      当count = 0；target = 当前遍历元素
 *      当当前元素和target相等，则count++；
 *      当当前元素和target相等，则count--；
 * 
 * @author: mafeng
 * @data: 2020-08-03 21:46:32
 **/
public class P169MajorityElement{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int majorityElement(int[] nums) {
            int target = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (count == 0) {
                    target = nums[i];
                    count++;
                }else {
                    if (target == nums[i]) {
                        count++;
                    }else {
                        count--;
                    }
                }
            }
            return target;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}