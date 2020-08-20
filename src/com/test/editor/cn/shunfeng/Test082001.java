package com.test.editor.cn.shunfeng;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 题目：赏金猎人
 * 分析：需要考虑end相等的情况，代码没有考虑，之后会添加
 *
 * @author mafeng
 * @data 2020/8/20
 **/
public class Test082001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] start = new int[n];
        int[] end = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
            value[i] = sc.nextInt();
            sc.nextLine();
        }

        int maxEnd = 0;
        for (int i = 0; i < n; i++) {
            maxEnd = Math.max(maxEnd, end[i]);
        }
        Pair[] pairs = new Pair[n];
        int index = 0;
        for (int i = index; i < n; i++) {
            Pair pair = new Pair(start[i], end[i], value[i]);
            pairs[i] = pair;
        }
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.start - o2.start;
            }
        });

        long[] dp = new long[maxEnd + 1];
        dp[0] = 0;
        for (int i = 1; i <= maxEnd; i++) {
            dp[i] = dp[i - 1];
            for (int j = 0; j < n; j++) {
                if (pairs[j].end == i) {
                    dp[i] = Math.max(dp[i], dp[i - pairs[j].end + pairs[j].start] + pairs[j].value);
                }
            }
        }
        System.out.println(dp[maxEnd]);
    }

    static class Pair {
        int start;
        int end;
        int value;

        public Pair(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}
