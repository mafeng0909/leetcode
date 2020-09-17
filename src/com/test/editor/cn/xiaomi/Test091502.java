package com.test.editor.cn.xiaomi;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/15
 **/
public class Test091502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            boolean flag = set.add(c);
            if (flag) {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}
