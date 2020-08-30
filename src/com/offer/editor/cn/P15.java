package com.offer.editor.cn;

/**
 * 分析：利用 n & n - 1
 *      减少比较次数
 *
 * @author mafeng
 * @data 2020/8/30
 **/
public class P15 {
    public static void main(String[] args) {

    }

    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }
}
