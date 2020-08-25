package com.test.editor.cn.shenxinfu;

import java.util.Scanner;

/**
 * 逆向思维：除了自己，所有都加一 => 相当于只有自己减一，其他都不变
 *
 * @author mafeng
 * @data 2020/8/25
 **/
public class Test082501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long sum = 0;
        long min = mixIndex(arr);
        for (long i : arr) {
            sum += i - min;
        }
        System.out.println(sum);
    }

    /**
     * 求最小索引
     *
     * @param arr
     * @return
     */
    public static long mixIndex(long[] arr) {
        long min = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
