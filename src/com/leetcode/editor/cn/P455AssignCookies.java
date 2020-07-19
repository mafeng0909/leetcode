//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干
//的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满
//足越多数量的孩子，并输出这个最大数值。 
//
// 注意： 
//
// 你可以假设胃口值为正。 
//一个小朋友最多只能拥有一块饼干。 
//
// 示例 1: 
//
// 
//输入: [1,2,3], [1,1]
//
//输出: 1
//
//解释: 
//你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
//虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
//所以你应该输出1。
// 
//
// 示例 2: 
//
// 
//输入: [1,2], [1,2,3]
//
//输出: 2
//
//解释: 
//你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
//你拥有的饼干数量和尺寸都足以让所有孩子满足。
//所以你应该输出2.
// 
// Related Topics 贪心算法

package com.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Java：分发饼干
 * 贪心算法
 * @author mafeng
 */
public class P455AssignCookies{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        /**
         *
         * @param g 每个孩子的胃口量
         * @param s 现有饼干的量
         * @return 能满足孩子的最大量
         */
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            // count记录能满足孩子的个数，也指孩子胃口量数组g的索引
            int count = 0;
            // index指现有饼干数组s的索引
            int index = 0;
            while (count < g.length && index < s.length) {
                if (g[count] <= s[index]) {
                    count++;
                }
                index++;
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}