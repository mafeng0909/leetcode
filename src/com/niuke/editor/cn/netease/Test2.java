package com.niuke.editor.cn.netease;

import java.util.Scanner;

/**
 * 题目链接：https://www.nowcoder.com/practice/fe6c73cb899c4fe1bdd773f8d3b42c3d?tpId=122&&tqId=33649&rp=1&ru=/ta/exam-wangyi&qru=/ta/exam-wangyi/question-ranking
 *
 * @author mafeng
 * @data 2020/8/6
 **/
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 每组数据的共同部分
            int num = sc.nextInt();
            int power = sc.nextInt();
            sc.nextLine();
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
            }
            sc.nextLine();

            // 对数据进行操作
            for (int i : arr) {
                if (i <= power) {
                    power += i;
                }else {
                    power += greatestCommonDivisor(power, i);
                }
            }
            System.out.println(power);
        }
    }

    /**
     * 求最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    public static int greatestCommonDivisor(int a, int b) {
        int n = Math.min(a, b);
        while (n > 1) {
            if (a % n == 0 && b % n == 0) {
                break;
            }
            n--;
        }
        return n;
    }
}
