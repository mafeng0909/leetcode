package com.test.editor.cn.shunfeng;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 题目：带宽的最大收益
 *
 * @author mafeng
 * @data 2020/8/20
 **/
public class Test082002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] arrA = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }
        sc.nextLine();
        Pair[] pairs = new Pair[m];
        for (int i = 0; i < m; i++) {
            int b = sc.nextInt();
            int c = sc.nextInt();
            pairs[i] = new Pair(b, c);
            sc.nextLine();
        }

        Arrays.sort(arrA);
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.need - o2.need;
            }
        });

        int maxRes = 0;
        int[] visited = new int[m];
        // 外层循环是空闲宽带的遍历
        for (int i = 0; i < n; i++) {
            // 内层循环是需求的遍历
            int index = -1;
            int max = 0;
            for (int j = 0; j < m; j++) {
                // 如果当前空闲的宽带可以满足当前的需求
                if (visited[j] == 0 && arrA[i] >= pairs[j].need) {
                    if (max < pairs[j].value) {
                        max = pairs[j].value;
                        index = j;
                    }
                }
            }
            if (index != -1) {
                visited[index] = 1;
                maxRes += max;
            }
        }
        System.out.println(maxRes);
    }

    static class Pair {
        int need;
        int value;

        public Pair(int need, int value) {
            this.need = need;
            this.value = value;
        }
    }
}
