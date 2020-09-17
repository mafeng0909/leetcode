package com.test.editor.cn.huanju;

/**
 * @author mafeng
 * @data 2020/8/31
 **/
public class Test083101 {
    public static void main(String[] args) {

    }

    public long nextNarcissisticNumber (int n) {
        // write code here
        if (n < 9) {
            return n + 1;
        }
        long num = n + 1;
        while (true) {
            String s = String.valueOf(num);
            int len = s.length();
            char[] chars = s.toCharArray();
            long sum = 0;
            for (char c : chars) {
                sum += (long)Math.pow(c - '0', len);
            }
            if (sum == num) {
                break;
            }
            num++;
        }
        return num;
    }

}
