package com.test.editor.cn.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 原问题与子问题：
 * 状态：dp[i] 表示 和为i的所有组合情况
 * 临界状态：
 * 转换方程：
 *
 * @author mafeng
 * @data 2020/8/8
 **/
public class Test080803 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);
        int len = sum / 2;

        int[] dp = new int[len + 1];
        dp[arr[0]] = 1;
        for (int i = arr[0]; i < len; i++) {

        }
    }

}
