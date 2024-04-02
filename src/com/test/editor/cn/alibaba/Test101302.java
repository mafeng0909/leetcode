package com.test.editor.cn.alibaba;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/10/13
 **/
public class Test101302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            int A = sc.nextInt();
            int B = sc.nextInt();
            int k = sc.nextInt();

            int numA = (int)(Math.pow(A, k - 2) % 1000000007);
            int numA2 = A * A % 1000000007;
            int numB = k * B % 1000000007;
            res[i] = numA * (numA2 - numB) % 1000000007;
        }
        for (int re : res) {
            System.out.println(re);
        }
    }
}
