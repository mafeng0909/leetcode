package com.test.editor.cn.huawei;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/23
 **/
public class Test092301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        String string = s[0];
        String target = s[1];
        int length = target.length();
        int len = (int)(length * 0.8);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("*");
        }

        if (length == 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == target.charAt(0)) {
                    sb3.append("*");
                }else {
                    sb3.append(string.charAt(i));
                }
            }
            System.out.println(sb3.toString());
        }else {
            /*if (string.length() < len) {
                System.out.println(string);
            }else {*/
            StringBuilder sb2 = new StringBuilder();
            int index = 0;
            for (int i = 0; i < string.length() - length + 1; i++) {
                if (judge(string.substring(i, i + length), target, len)) {
                    sb2.append(sb);
                    i = i + length - 1;
                    index = i + 1;
                }else {
                    sb2.append(string.charAt(i));
                    index = i + 1;
                    if (i == string.length() - length) {
                        sb2.append(string.substring(i + 1));
                        i = string.length();
                    }
                }
            }
            if (index < string.length()) {
                String substring = string.substring(index);
                if (substring.length() >= len) {
                    if (judge(substring, target, len)) {
                        for (int i = 0; i < substring.length(); i++) {
                            sb2.append("*");
                        }
                    }
                }else {
                    sb2.append(string.substring(index));
                }
            }
            System.out.println(sb2.toString());
        }
    }

    public static boolean judge(String s, String target, int len) {
        char[] chars = target.toCharArray();
        int index = -1;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < chars.length; j++) {
                if (index + 2 < j) {
                    break;
                }
                if (index + 2 >= j && s.charAt(i) == chars[j]) {
                    index = j;
                    count++;
                    break;
                }
            }
        }
        return count >= len;
    }
}
