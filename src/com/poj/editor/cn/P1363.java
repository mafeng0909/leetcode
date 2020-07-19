package com.poj.editor.cn;

import java.util.Queue;
import java.util.Stack;

/**
 * @author mafeng
 * @date 2020/4/24 23:56
 */
public class P1363 {
    public static void main(String[] args) {

    }

    public static boolean checkIsTrue(Queue<Integer> queue) {
        if (queue.size() <= 2) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int n = queue.size();
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            if (i == queue.peek()) {
                queue.poll();
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
