package com.offer.editor.cn;

/**
 * 题目：买卖股票
 * 分析：贪心算法
 *      遍历数组，将当天的价格减去之前的最小值，最后取最大值
 *      buy = Math.min(buy, prices[i - 1])
 *      sell = Math.max(sell, prices[i] - buy)
 *
 * @author mafeng
 * @data 2020/7/26
 **/
public class P63 {
    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int buy = prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.min(buy, prices[i - 1]);
            sell = Math.max(sell, prices[i] - buy);
        }
        return sell;
    }
}
