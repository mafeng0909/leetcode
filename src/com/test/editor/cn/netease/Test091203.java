package com.test.editor.cn.netease;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/12
 **/
public class Test091203 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int power = sc.nextInt();
        sc.nextLine();

        int[] arr = new int[n];
        for (int i = 1; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 当power <= 深度
        int deep = maxDeep(arr);
        if (power <= deep) {
            System.out.println(power + 1);
        }else {
            int num = (power - deep) / 2;
            int count = deep + 1 + num;
            if (count > n) {
                System.out.println(n);
            }else {
                System.out.println(deep + 1 + num);
            }
        }
    }

    /**
     * 求树的深度
     *
     * @param arr
     * @return
     */
    public static int maxDeep(int[] arr) {
        Deque<Integer> queue = new LinkedList<>();
        Deque<Integer> deep = new LinkedList<>();
        queue.addLast(0);
        deep.addLast(1);
        int max = 0;
        while (!queue.isEmpty() && !deep.isEmpty()) {
            Integer integer = deep.pollFirst();
            int count = 0;
            while (integer > 0) {
                Integer poll = queue.pollFirst();
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] == poll) {
                        queue.addLast(i);
                        count++;
                    }
                }
                integer--;
            }
            if (count != 0) {
                deep.addFirst(count);
                max++;
            }
        }
        return max;
    }

}
