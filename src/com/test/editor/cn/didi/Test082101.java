package com.test.editor.cn.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/8/21
 **/
public class Test082101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n % 2 != 0 || n <= 200 || n > 2000) {
            System.out.println(0);
        }else {
            int n100 = n / 100;
            int n10 = n % 100 / 10;
            int n1 = n % 10;

            int count = 0;
            List<List<Integer>> res = new ArrayList<>();

            int a = n100 / 2;
            // 说明十位不能进位
            if (n100 % 2 == 0) {
                // 第一种情况：2c >= 10
                int c1 = (n1 + 10) / 2;
                int b1 = n10 - 1 - c1;
                if (n10 >= c1 && a != b1 && a != c1) {
                    count++;
                    int abc1 = a * 100 + b1 * 10 + c1;
                    int acc1 = a * 100 + c1 * 10 + c1;
                    List<Integer> list = new ArrayList<>();
                    list.add(abc1);
                    list.add(acc1);
                    res.add(list);
                }

                // 第二种情况：2c < 10
                int c2 = n1 / 2;
                int b2 = n10 - c2;
                if (a != b2 && a != c2) {
                    count++;
                    int abc2 = a * 100 + b2 * 10 + c2;
                    int acc2 = a * 100 + c2 * 10 + c2;
                    List<Integer> list = new ArrayList<>();
                    list.add(abc2);
                    list.add(acc2);
                    res.add(list);
                }

            // 说明十位能进位
            }else {
                // 第一种情况：2c >= 10
                int c1 = (n1 + 10) / 2;
                int b1 = n10 + 10 - 1 - c1;
                if (a != b1 && a != c1) {
                    count++;
                    int abc1 = a * 100 + b1 * 10 + c1;
                    int acc1 = a * 100 + c1 * 10 + c1;
                    List<Integer> list = new ArrayList<>();
                    list.add(abc1);
                    list.add(acc1);
                    res.add(list);
                }

                // 第二种情况：2c < 10
                int c2 = n1 / 2;
                int b2 = n10 + 10 - c2;
                if (a != b2 && a != c2) {
                    count++;
                    int abc2 = a * 100 + b2 * 10 + c2;
                    int acc2 = a * 100 + c2 * 10 + c2;
                    List<Integer> list = new ArrayList<>();
                    list.add(abc2);
                    list.add(acc2);
                    res.add(list);
                }
            }

            System.out.println(count);
            for (List<Integer> list : res) {
                System.out.print(list.get(0));
                System.out.print(" ");
                System.out.println(list.get(1));
            }
        }
    }
}
