package com.offer.editor.cn;

/**
 * @author mafeng
 * @data 2020/8/30
 **/
public class P17 {
    public static void main(String[] args) {

    }

    public int[] printNumbers(int n) {
        int num = (int)Math.pow(10, n) - 1;
        int[] res = new int[num];
        for(int i = 0; i < num; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
