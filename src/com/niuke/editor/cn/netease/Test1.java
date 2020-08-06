package com.niuke.editor.cn.netease;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mafeng
 * @data 2020/8/6
 **/
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] grades = new int[n];
        for (int i = 0; i < n; i++) {
            grades[i] = sc.nextInt();
        }
        sc.nextLine();
        int q = sc.nextInt();
        sc.nextLine();
        int[] index = new int[q];
        for (int i = 0; i < q; i++) {
            index[i] = sc.nextInt();
        }

        int[] temp = Arrays.copyOf(grades, n);
        Arrays.sort(temp);

        DecimalFormat df = new DecimalFormat("#.000000");
        for (int i : index) {
            if (i >= n) {
                System.out.print("0.000000");
            }else {
                int num = computeQ(temp, grades[i - 1]);
                System.out.println(df.format((double) num / n * 100));
            }
        }
    }

    public static int computeQ(int[] temp, int grade) {
        for (int i = 0; i < temp.length; i++) {
            if (grade == temp[i]) {
                return i;
            }
        }
        return 0;
    }
}
