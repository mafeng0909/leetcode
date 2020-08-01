package com.test.editor.cn;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/7/31
 **/
public class Test0731 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        double count = 0;
        for (int i = 0; i <= n; i++) {
            count += (C(n, i) * Math.pow(m, i));
        }
        System.out.println(count);
    }

    public static int factorial(int number) {
        if (number == 0) {
            return 1;
        }
        return factorial(number - 1) * number;
    }

    public static double C(int n, int r) {
        return factorial(n) / (factorial(n - r) * factorial(r));
    }

}
