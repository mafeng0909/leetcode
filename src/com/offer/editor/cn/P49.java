package com.offer.editor.cn;

/**
 * @author mafeng
 * 题目：丑数
 *
 * @data 2020/7/21
 **/
public class P49 {
    public static void main(String[] args) {

    }

    public static int nthUglyNumber(int n) {
        if (n < 0) {
            return 0;
        }
        int[] res = new int[n];
        res[0] = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;

        for (int i = 1; i < n; i++) {
            int min = Math.min(res[multiply2] * 2, Math.min(res[multiply3] * 3, res[multiply5] * 5));
            res[i] = min;
            if (min == res[multiply2] * 2) {
                multiply2++;
            }
            if (min == res[multiply3] * 3) {
                multiply3++;
            }
            if (min == res[multiply5] * 5) {
                multiply5++;
            }
        }
        return res[n - 1];
    }
}
