package com.test.editor.cn.dajiang;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author mafeng
 * @data 2020/8/16
 **/
public class Test081603 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int k = sc.nextInt();
        String res = removeK(num, k);
        System.out.println(res);
    }

    public static String removeK(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int temp = num.charAt(i) - '0';
            while (stack.size() != 0 && stack.peek() > temp && k > 0) {
                stack.pop();
                k--;
            }
            if (stack.size() != 0 || temp != 0) {
                stack.push(temp);
            }
        }
        while (k > 0 && stack.size() != 0) {
            stack.pop();
            k--;
        }

        StringBuilder stringBuilder = new StringBuilder();

        // 去掉开头可能存在的0
        boolean flag = true;
        for (Integer integer : stack) {
            if (flag && integer == 0) {
                continue;
            }
            flag = false;
            stringBuilder.append(integer);
        }
        // 如果
        if (stringBuilder.length() == 0) {
            return "0";
        }
        return stringBuilder.toString();
    }
}