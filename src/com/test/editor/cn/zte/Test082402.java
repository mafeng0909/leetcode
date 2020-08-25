package com.test.editor.cn.zte;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/8/24
 **/
public class Test082402 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String s = sc.next();
            long l = sc.nextLong();
            long r = sc.nextLong();

            long sum = 0;
            for (long j  = l; j <= r; j++) {
                sum += Long.parseLong(s, (int) j);
            }
            if (sum % 10 / 2 == 0) {
                res[i] = 0;
            }else {
                res[i] = 1;
            }
        }

        for (int re : res) {
            System.out.println(re);
        }


    }
}
