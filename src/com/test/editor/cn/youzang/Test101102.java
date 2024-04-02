package com.test.editor.cn.youzang;

import java.util.ArrayList;

/**
 * @author mafeng
 * @data 2020/10/11
 **/
public class Test101102 {
    public static void main(String[] args) {

    }

    public String largestMultipleOfThree (ArrayList<Integer> digits) {
        // write code here
        int[] cnt = new int[10];
        int[] modulo = new int[3];
        int sum = 0;
        for (Integer digit : digits) {
            ++cnt[digit];
            ++modulo[digit % 3];
            sum += digit;
        }
        final int left;
        int rest;
        final int mod = sum % 3;
        if (mod == 0) {
            left = rest = 0;
        }else {
            if (modulo[mod] >= 1) {
                left = mod;
                rest = 1;
            }else {
                left = 2 * mod % 3;
                rest = 2;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            char ch = (char) (i + '0');
            for (int j = 0; j < cnt[i]; j++) {
                if (rest > 0 && i % 3 == left) {
                    --rest;
                }else {
                    sb.append(ch);
                }
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb = new StringBuilder("0");
        }
        return sb.reverse().toString();
    }
}
