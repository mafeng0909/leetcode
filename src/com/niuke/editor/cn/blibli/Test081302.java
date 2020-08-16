package com.niuke.editor.cn.blibli;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author mafeng
 * @data 2020/8/13
 **/
public class Test081302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i] == ' ') {
                continue;
            }
            if (stack.isEmpty()) {
                stack.add(chars[i]);
                continue;
            }
            if (chars[i] == ')') {
                Character pop = stack.peek();
                if (pop != '(') {
                    break;
                }
                stack.pop();
            }else if (chars[i] == ']') {
                Character pop = stack.peek();
                if (pop != '[') {
                    break;
                }
                stack.pop();
            }else if (chars[i] == '}') {
                Character pop = stack.peek();
                if (pop != '{') {
                    break;
                }
                stack.pop();
            }else {
                stack.add(chars[i]);
            }
        }
        if (stack.isEmpty()) {
            System.out.println("true");
        }else {
            System.out.println("false");
        }

    }
}
