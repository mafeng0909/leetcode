package com.test.editor.cn.shopee;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mafeng
 * @data 2020/9/16
 **/
public class Test091602 {

    public static void main(String[] args) {

    }

    public static int longestPalindrome (String s) {
        // write code here
        int res = 0;
        int count = 0;
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            boolean flag = set.add(aChar);
            if (!flag) {
                count++;
                set.remove(aChar);
            }
        }
        if (set.size() != 0) {
            res = 1;
        }
        return res + count * 2;
    }
}
