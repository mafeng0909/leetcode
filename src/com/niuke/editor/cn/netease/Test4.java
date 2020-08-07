package com.niuke.editor.cn.netease;

import java.util.Scanner;

/**
 * 题目链接：https://www.nowcoder.com/practice/fe30a13b5fb84b339cb6cb3f70dca699?tpId=122&&tqId=33655&rp=1&ru=/ta/exam-wangyi&qru=/ta/exam-wangyi/question-ranking
 * 没做出来！！！
 * @author mafeng
 * @data 2020/8/7
 **/
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = sc.nextLine();
        }

        int[][] arr = new int[n][m];
        int sum = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length(); j++) {
                arr[i][j] = strings[i].charAt(j);
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
    }
}
