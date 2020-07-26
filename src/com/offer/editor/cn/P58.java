package com.offer.editor.cn;

/**
 * 题目：翻转单词顺序
 * 分析：先将句子拆分成一个个的单词，然后再进行逆序拼接
 *      注意：拆分会出现空字符
 *
 * @author mafeng
 * @data 2020/7/26
 **/
public class P58 {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if ("".equals(strings[i]) || strings[i] == null) {
                continue;
            }
            stringBuilder.append(strings[i]);
            stringBuilder.append(" ");
        }
        // trim() 是去掉首尾空字符的
        return stringBuilder.toString().trim();
    }
}
