//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
//
// 注意：你不能在买入股票前卖出股票。
//
//
//
// 示例 1:
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
//
//
// 示例 2:
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
//
// Related Topics 数组 动态规划

package com.leetcode.editor.cn;
/**
 * Java：买卖股票的最佳时机
 * 分析：贪心思想 -> 每次都将当前位置减去之前的最小值，进而来增大收益
 *      有买入和卖出两种状态
 *      buy = max(buy, -price[i])   buy定义为负数，买入取最小
 *      sell = max(sell, prices[i] + buy)  收益取最大
 *      临界状态：buy = -price[i]
 *              sell = 0
 *
 * @author mafeng
 */
public class P121BestTimeToBuyAndSellStock{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxValue = 0;
            for (int price : prices) {
                // 判断当前price是否是最小价格
                if (price < minPrice) {
                    minPrice = price;
                } else {
                    // 判断当前收益是不是比之前最大收益大
                    if (price - minPrice > maxValue) {
                        maxValue = price - minPrice;
                    }
                }
            }
            return maxValue;
        }

        public int maxProfit2(int[] prices) {
            if (prices.length <= 1) {
                return 0;
            }
            int buy = -prices[0];
            int sell = 0;
            for (int i = 1; i < prices.length; i++) {
                buy = Math.max(buy, -prices[i]);
                sell = Math.max(sell, prices[i] + buy);
            }
            return sell;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
