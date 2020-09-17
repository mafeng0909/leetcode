package com.test.editor.cn.xiaomi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author mafeng
 * @data 2020/9/15
 **/
public class Test091501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Boolean> res = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            res.add(judge(s));
        }
        for (Boolean re : res) {
            System.out.println(re);
        }
    }

    public static boolean judge(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < chars.length) {
            if (stack.isEmpty()) {
                stack.add(chars[index]);
                index++;
                continue;
            }
            Character peek = stack.peek();
            if (chars[index] == ']' && peek == '[') {
                stack.pop();
                index++;
            }else if (chars[index] == ')' && peek == '(') {
                stack.pop();
                index++;
            }else if (chars[index] == '}' && peek == '{') {
                stack.pop();
                index++;
            }else {
                stack.add(chars[index]);
                index++;
            }
        }
        return stack.isEmpty();
    }
}
