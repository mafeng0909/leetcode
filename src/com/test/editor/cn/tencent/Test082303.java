package com.test.editor.cn.tencent;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/8/23
 **/
public class Test082303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
//        int max = (int)Math.pow(10, 6);
//        int[] dp = new int[max];
        int[] res = new int[100];
        for (int i = 0; i < T; i++) {
            long n = sc.nextLong();
            sc.nextLine();

            int maxVal = 0;
            for (int l = 0; l < n / 2; l++) {
//                if (dp[l] != 0) {
//                    dp[l] = calculateVal(l);
//                }
//                int val = dp[l] + calculateVal(n - l);
                int val = calculateVal(l) + calculateVal(n - l);
                maxVal = Math.max(maxVal, val);
            }
            res[i] = maxVal;
        }
        for (int re : res) {
            if (re != 0) {
                System.out.println(re);
            }
        }
    }

    public static int calculateVal(long n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int val = 0;
        for (char c : chars) {
            val += c - '0';
        }
        return val;
    }
}
