package com.test.editor.cn.alibaba;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/10/13
 **/
public class Test101301 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[t];
        for (int i = 0; i < t; i++) {
            String[] s = scanner.nextLine().split(" ");
            strings[i] = getResult(s[0], s[1]);
        }
        for (String res : strings) {
            System.out.println(res);
        }
    }

    private static String getResult(String a, String b) {
        if (a.length() < b.length()) {
            return b;
        } else {
            int index = 0;
            char maxChar = a.charAt(0);
            for (int i = 0; i < a.length(); i++) {
                if (maxChar <= a.charAt(i)) {
                    maxChar = a.charAt(i);
                    index = i;
                }
            }
            char[] chars = a.toCharArray();
            char temp = chars[0];
            chars[0] = chars[index];
            chars[index] = temp;
            StringBuilder stringBuilder = new StringBuilder();
            for (char aChar : chars) {
                stringBuilder.append(aChar);
            }
            String s = stringBuilder.toString();
            return s.compareTo(b) > 0 ? s : b;
        }
    }
}
