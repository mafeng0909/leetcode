package com.test.editor.cn.aiqiyi;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author mafeng
 * @data 2020/8/23
 **/
public class Test082302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Set<Pair<Integer, Integer>> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int x = 0;
        int y = 0;
        set.add(new Pair<>(x, y));
        Boolean flag1 = false;
        for (char c : chars) {
            if (c == 'N') {
                y += 1;
            }else if (c == 'S') {
                y -= 1;
            }else if (c == 'E') {
                x += 1;
            }else if (c == 'W') {
                x -= 1;
            }else {
                break;
            }

            boolean flag = set.add(new Pair<>(x, y));
            if (!flag) {
                System.out.println("True");
                flag1 = true;
                break;
            }
        }
        if (!flag1) {
            System.out.println("False");
        }
    }
}
