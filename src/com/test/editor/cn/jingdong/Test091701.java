package com.test.editor.cn.jingdong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/17
 **/
public class Test091701 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> res = new ArrayList<>();
        String s = sc.nextLine();

        find(s, res);

        for (String re : res) {
            System.out.print(re);
            System.out.print(" ");
        }
    }

    public static void find(String s, List<String> res) {
        int len = s.length();
        for (int i = 0; i < len - 3; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                continue;
            }
            if (judge(s, i)) {
                res.add(s.substring(i, i + 4));
            }
        }
    }

    public static boolean judge(String s, int index) {
        if (Character.isDigit(s.charAt(index + 1)) && Character.isDigit(s.charAt(index + 2)) && Character.isDigit(s.charAt(index + 3))) {
            String substring = s.substring(index, index + 4);
            int num = Integer.parseInt(substring);
            return num >= 1000 && num <= 3999;
        }
        return false;
    }
}
