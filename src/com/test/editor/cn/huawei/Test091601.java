package com.test.editor.cn.huawei;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/16
 **/
public class Test091601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().trim().split(",");
        String target = "0123432156578987510";
        int index = 0;
        for (String s : strings) {
            if (s.equals(target.substring(index, index + 1))) {
                continue;
            }
            if (s.equals(target.substring(index + 1, index + 2))) {
                index++;
                continue;
            }
            if ("-1".equals(s)) {
                System.out.println("Out of path");
            }
            // 判断字母

            // 否则直接bad path
        }
    }
}
