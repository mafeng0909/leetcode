package com.niuke.editor.cn.netease;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目链接：https://www.nowcoder.com/practice/62cdf520b9d94616b6644ac03a0306ff?tpId=122&&tqId=33648&rp=1&ru=/ta/exam-wangyi&qru=/ta/exam-wangyi/question-ranking
 *     注意左右边界
 * @author mafeng
 * @data 2020/8/6
 **/
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] arr = new int[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.nextLine();

        Arrays.sort(arr);
        int max = Math.max(arr[0], l - arr[n - 1]) * 2;
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i] - arr[i - 1]);
        }
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format((double) max / 2));
    }
}
