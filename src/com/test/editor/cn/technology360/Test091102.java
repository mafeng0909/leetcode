package com.test.editor.cn.technology360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author mafeng
 * @data 2020/9/11
 **/
public class Test091102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Stack<Integer> onLine = new Stack<>();
        Stack<Integer> offLine = new Stack<>();

        for (int i = 0; i < m; i++) {
            sc.nextLine();
            int k = sc.nextInt();
            int flag = sc.nextInt();
            if (flag == 1) {
                onLine.push(k);
            }else if (flag == 0) {
                offLine.push(k);
            }
        }

        int[] res = new int[n + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i;
        }

        if (onLine.size() == 1 && offLine.size() == 1) {
            if (!onLine.peek().equals(offLine.peek())) {
                res[onLine.pop()] = 0;
                res[offLine.pop()] = 0;
            }
        }

        boolean flag = true;
        while (!offLine.isEmpty()) {
            Integer pop = offLine.pop();
            if (flag) {
                flag = false;
            }else {
                res[pop] = 0;
            }
            Stack<Integer> clone = (Stack<Integer>) onLine.clone();
            while (!clone.isEmpty()) {
                if (clone.peek().equals(pop)) {
                    res[pop] = 0;
                    break;
                }else {
                    res[clone.pop()] = 0;
                }
            }
        }


        for (int re : res) {
            if (re != 0) {
                System.out.print(re);
                System.out.print(" ");
            }
        }
    }
}
