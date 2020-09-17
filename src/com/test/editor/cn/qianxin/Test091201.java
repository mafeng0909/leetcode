package com.test.editor.cn.qianxin;

/**
 * @author mafeng
 * @data 2020/9/12
 **/
public class Test091201 {
    public static void main(String[] args) {
        int[] candies = {3, 5, 7, 2, 8, 8, 15, 3};
        int[] coins = {1, 0, 1, 0, 1, 0, 1, 0};
        System.out.println(maxCandies(candies, coins, 3));
    }

    public static int maxCandies(int[] candies, int[] coins, int n) {
        // 基础结果
        int res = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] == 0) {
                res += candies[i];
            }
        }
        if (n <= 0) {
            return res;
        }

        int start = 0;
        int end = n - 1;
        int maxChange = 0;
        while (end < coins.length) {
            int curChange = 0;
            for (int i = start; i <= end; i++) {
                if (coins[i] == 1) {
                    curChange += candies[i];
                }
            }
            maxChange = Math.max(maxChange, curChange);
            start++;
            end++;
        }
        return res + maxChange;
    }
}
