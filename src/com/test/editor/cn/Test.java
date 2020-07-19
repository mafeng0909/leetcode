package com.test.editor.cn;

import java.util.Scanner;

/**
 * @author mafeng
 * @date 2020/7/17 20:16
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int left = 0;
        for (int right = 0; right < chars.length; right++) {
            if (right == chars.length - 1) {
                System.out.println(s.substring(left, right - 1));
                break;
            }
            if (chars[right] == ';') {
                System.out.println(s.substring(left, right));
                left = right + 1;
            }
        }
    }
}
