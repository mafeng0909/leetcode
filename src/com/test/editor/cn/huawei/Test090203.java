package com.test.editor.cn.huawei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/2
 **/
public class Test090203 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        int[] sizes = new int[n];
        for (int i = 0; i < n; i++) {
            sizes[i] = sc.nextInt();
        }
        sc.nextLine();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(sizes[i], values[i]);
        }
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.size - o2.size;
            }
        });

        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j >= pairs[i].size; j++) {
                dp[j] = Math.max(dp[j], dp[j - pairs[i].size] + pairs[i].value);
            }
        }

        System.out.println(dp[k]);
    }

    public static class Pair {
        int size;
        int value;

        public Pair(int size, int value) {
            this.size = size;
            this.value = value;
        }
    }
}
