package com.offer.editor.cn;

import java.util.Stack;

/**
 * @author mafeng
 * @data 2020/8/28
 **/
public class P05 {
    public static void main(String[] args) {

    }

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
