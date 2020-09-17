package com.test.editor.cn.xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/8
 **/
public class Test090802 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.trim().split(" ");

        List<String> res = new ArrayList<>();
        List<Character> temp = new ArrayList<>();

        dfs(strings, 0, res, temp);
        for (String re : res) {
            boolean flag = judge(re);
            if (flag) {
                System.out.println(re + "--circular dependency");
            }else {
                System.out.println(re);
            }
        }
    }

    public static void dfs(String[] strings, int index, List<String> res, List<Character> temp) {
        if (index == strings.length) {
            StringBuilder sb = new StringBuilder();
            for (Character s : temp) {
                sb.append(s);
            }
            res.add(sb.toString());
            return;
        }
        String s = strings[index];
        for (int i = 0; i < s.length(); i++) {
            temp.add(s.charAt(i));
            dfs(strings, index + 1, res, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static boolean judge(String s) {
        int[] flag = new int[128];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (flag[aChar] == 0) {
                flag[aChar] = 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
