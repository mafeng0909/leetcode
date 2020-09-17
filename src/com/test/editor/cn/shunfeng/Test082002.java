package com.test.editor.cn.shunfeng;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 题目：带宽的最大收益
 *      小A的购买了一批服务器，他准备将这些服务器租用出去。 每一个服务器有一个固定的带宽，
 *      人们根据自己需要的带宽来租用这些服务器。一台服务器只能租给一个人。
 *      小A现在有n个空闲的服务器，第 i 个服务器拥有ai的带宽。
 *      有m个客户来租服务器，第 i 位客户需要带宽至少为bi的服务器，并且愿意花ci元作为预算。
 *      （服务器带宽独立不可叠加，若不能成功租出则输出0）
 *      小A可以选择拒绝一些人，现在，小A想知道自己的服务器最多能租多少钱？
 *      输入描述 输入第一行包含两个数n,m  接下来1行n个数，第i个数ai代表第 i 个服务器的带宽大小。
 *      接下来m行，每行两个数bi,ci，代表客户需求的带宽大小和他的预算。
 *      n,m≤1000 , 1≤ai,bi,ci≤1000 输出描述 输出一个数，即小A最多能租多少元的服务器出去。
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
