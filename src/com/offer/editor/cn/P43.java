package com.offer.editor.cn;

/**
 * @author mafeng
 * 题目：1～n整数中1出现的次数
 * 分析：1 cur = 0 -> count += high * digit
 *      2 cur = 1 -> count += high * digit + low + 1
 *      3 cur > 1 -> count += (high + 1) * digit
 *
 * @data 2020/7/21
 **/
public class P43 {
    public static void main(String[] args) {
        System.out.println(countDigitOne(1));
    }

    public static int countDigitOne(int n) {
        int count = 0;
        int digit = 1;
        int cur = 0;
        int high = 0;
        int low = 0;
        while ((n / digit) != 0) {
            high = n / (digit * 10);
            low = n - (n / digit) * digit;
            cur = (n / digit) % 10;
            if (cur == 0) {
                count += high * digit;
            }else if (cur == 1) {
                count += high * digit + low + 1;
            }else if (cur > 1) {
                count += (high + 1) * digit;
            }
            digit *= 10;
        }
        return count;
    }
}
