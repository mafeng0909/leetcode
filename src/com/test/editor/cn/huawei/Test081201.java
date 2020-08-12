package com.test.editor.cn.huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author mafeng
 * @data 2020/8/12
 **/
public class Test081201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.trim().split(",");
        int[] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

        Stack<Integer> change10 = new Stack<>();
        Stack<Integer> change5 = new Stack<>();

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            index = i;
            if (arr[i] == 5) {
                change5.push(5);
                continue;
            }
            if (arr[i] % 5 != 0 || change5.isEmpty()) {
                break;
            }
            int num = arr[i] - 5;
            if (num == 5) {
                change5.pop();
                change10.add(i);
            }
            if (num == 15) {
                if (!change10.isEmpty()) {
                    change10.pop();
                    change5.pop();
                } else {
                    if (change5.size() > 3) {
                        for (int j = 0; j < 3; j++) {
                            change5.pop();
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        if (index < arr.length - 1) {
            index++;
            System.out.println("false," + index);
        }else {
            index++;
            System.out.println("true," + index);
        }
    }
}
