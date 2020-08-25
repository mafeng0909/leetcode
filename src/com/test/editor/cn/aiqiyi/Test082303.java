package com.test.editor.cn.aiqiyi;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author mafeng
 * @data 2020/8/23
 **/
public class Test082303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean flag = isValid(s);
        if (flag) {
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (c == ')' && pop != '(') {
                    return false;
                }
                if (c == ']' && pop != '[') {
                    return false;
                }
                if (c == '}' && pop != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
