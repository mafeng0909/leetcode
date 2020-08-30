package com.test.editor.cn.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/8/26
 **/
public class Test082602 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.trim().toCharArray();
        int flag = 0;
        int temp = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                temp = temp * 10 + (c - '0');
            }
            if (c == '[') {
                flag++;
            }
            if (c == ']') {
                if (flag == 1) {
                    list1.add(temp);
                    temp = 0;
                }else if (flag == 3) {
                    list2.add(temp);
                    temp = 0;
                }
                flag++;
            }
            if (c == ',') {
                if (flag == 1) {
                    list1.add(temp);
                    temp = 0;
                }else if (flag == 3) {
                    list2.add(temp);
                    temp = 0;
                }
            }
        }

        System.out.println(Arrays.toString(list1.toArray()));
        System.out.println(Arrays.toString(list2.toArray()));

    }
}
