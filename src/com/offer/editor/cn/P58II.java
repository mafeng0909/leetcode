package com.offer.editor.cn;

/**
 * 题目：将字符串循环左移K位
 *
 * @author mafeng
 * @data 2020/7/26
 **/
public class P58II {
    public static void main(String[] args) {

    }

    public static String reverseLeftWords(String s, int n) {
        if (n == 0 || s.length() <= 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.substring(n, s.length()));
        stringBuilder.append(s.substring(0, n));
        return stringBuilder.toString();
    }
}
