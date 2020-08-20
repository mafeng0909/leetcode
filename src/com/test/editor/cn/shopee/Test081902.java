package com.test.editor.cn.shopee;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author mafeng
 * @data 2020/8/19
 **/
public class Test081902 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String substring = s.trim().substring(1, s.length() - 1);
        char[] chars = substring.toCharArray();
        int len = chars.length;
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < chars.length) {
            if (stack.isEmpty()) {
                stack.push(chars[index]);
                continue;
            }

        }
    }
}
