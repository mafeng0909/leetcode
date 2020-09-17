package com.test.editor.cn.zte;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/17
 **/
public class Test091701 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int m = sc.nextInt();
        int c = sc.nextInt();

        int countUp = 0;
        int countDown = 0;
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int weight = sc.nextInt();

            int y0 = m * x + c;
            if (y0 > y) {
                countDown += weight;
            }else if (y0 < y){
                countUp += weight;
            }
        }
        System.out.println(Math.max(countUp, countDown));
    }
}
