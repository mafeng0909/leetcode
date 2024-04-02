package com.test.editor.cn.xiecheng;

import java.util.*;

/**
 * @author mafeng
 * @data 2020/10/13
 **/
public class Test101303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        String[] s = sc.nextLine().trim().split(" ");

        int bit = 1;
        for (String string : s) {
            if (!isAlpha(string)) {
                System.out.println(-1);
                bit = -1;
                break;
            }
        }
        if (bit == 1) {
            if (target.length() != s.length) {
                System.out.println(0);
            } else {
                Set<Character> set = new HashSet<>();
                Map<Character, String> map = new HashMap<>();
                int count = 1;
                for (int i = 0; i < target.length(); i++) {
                    char c = target.charAt(i);
                    boolean flag = set.add(c);
                    // 说明没有相应标志
                    if (flag) {
                        if (!map.containsValue(s[i]) && !map.containsKey(c)) {
                            map.put(c, s[i]);
                        } else {
                            count = 0;
                            break;
                        }
                    } else {
                        if (!map.containsKey(c) || !map.get(c).equals(s[i])) {
                            count = 0;
                            break;
                        }
                    }
                }
                System.out.println(count);
            }
        }

    }


    public static boolean isAlpha(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("[a-zA-Z]+");
    }
}
