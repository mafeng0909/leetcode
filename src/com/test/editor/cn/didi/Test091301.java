package com.test.editor.cn.didi;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/13
 **/
public class Test091301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        if (n >= s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
            System.out.println(sb.toString());
        }else {
            StringBuilder sb = new StringBuilder();
            int k = 0;
            while (n * k <= s.length()) {
                for (int i = n - 1; i >= 0; i--) {
                    int index = n * k + i;
                    if (index < s.length()) {
                        sb.append(s.charAt(index));
                    }
                }
                k++;
            }
            System.out.println(sb.toString());
        }
    }
}
