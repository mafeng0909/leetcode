//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//
//
// 示例 1:
//
// 输入: [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
//
//
// 示例 2:
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
//
//
// 示例 3:
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
//
//
//
// 提示：
//
//
// 1 <= prices.length <= 3 * 10 ^ 4
// 0 <= prices[i] <= 10 ^ 4
//
// Related Topics 贪心算法 数组

package com.leetcode.editor.cn;
/**
 * Java：买卖股票的最佳时机 II
 * 分析：由于可以无数次买入，但是每次买入之前需要将手中的股票卖掉
 *      1 只要有赚就可以买进。即将所有递增的加起来
 *      2 公式法
 *      注：每次买卖都要有成本
 *      buy = max(buy, sell - price[i])
 *      sell = max(sell, buy + prices[i])
 *      临界状态：buy = -price[i]
 *              sell = 0
 *
 * @author mafeng
 */
public class P122BestTimeToBuyAndSellStockIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length <= 1) {
                return 0;
            }
            int sell = 0;
            for (int i = 1; i < prices.length; i++) {
                // 只要有赚就可以买
                if (prices[i] > prices[i - 1]) {
                    sell += prices[i] - prices[i - 1];
                }
            }
            return sell;
        }

        public int maxProfit2(int[] prices) {
            if (prices.length <= 1) {
                return 0;
            }
            int buy = -prices[0];
            int sell = 0;
            for (int i = 1; i < prices.length; i++) {
                // 每次买卖都要有成本
                buy = Math.max(buy, sell - prices[i - 1]);
                sell = Math.max(sell, prices[i] + buy);
            }
            return sell;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
