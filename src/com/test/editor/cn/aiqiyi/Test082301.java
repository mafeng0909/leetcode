package com.test.editor.cn.aiqiyi;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/8/23
 **/
public class Test082301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int zero = zero(n);
        System.out.println(zero);

    }

    public static int zero(int num) {
        int sum = 0;
        while (num!=0) {
            sum += num / 5;
            num /= 5;
        }
        return sum;
    }

}
