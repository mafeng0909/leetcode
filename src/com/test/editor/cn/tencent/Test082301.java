package com.test.editor.cn.tencent;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/8/23
 **/
public class Test082301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (i == k - 1) {
                continue;
            }
            s.append(temp);
            if (i == n - 1) {
                break;
            }
            s.append(" ");
        }
        System.out.println(s.toString());
    }

}
