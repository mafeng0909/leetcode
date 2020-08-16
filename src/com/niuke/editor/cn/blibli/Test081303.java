package com.niuke.editor.cn.blibli;

/**
 * @author mafeng
 * @data 2020/8/13
 **/
public class Test081303 {
    public static void main(String[] args) {

    }

    public int getCoinCount (int N) {
        // write code here
        int num = 1024 - N;
        int num64 = num / 64;
        int num16 = (num % 64) / 16;
        int num4 = ((num % 64) % 16) / 4;
        int num1 = num - num4 * 4 - num16 * 16 - num64 * 64;
        return num1 + num4 + num16 + num64;

    }
}
