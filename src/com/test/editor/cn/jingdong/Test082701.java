package com.test.editor.cn.jingdong;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/8/27
 **/
public class Test082701 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int basicIndex = 0;
        int bitNum = 0;
        while (basicIndex <= n) {
            bitNum++;
            basicIndex += Math.pow(3, bitNum);
        }
        int res = 0;
        int[] nums = {2, 3, 5};
        basicIndex = (int)Math.pow(3, bitNum - 1);
        int count = n - basicIndex;
        if (count == 0) {
            for (int k = bitNum - 1; k > 0; k--) {
                res = res * 10 + nums[2];
            }
        }else {
            // 求出真正顺序
            int bitK = 1;
            int basicK = (int)Math.pow(3, bitK);
            while (basicK <= count) {
                bitK++;
                basicK = (int)Math.pow(3, bitK);
            }
            // 当多出的数刚好等于
            for (int k = bitNum; k > 0; k--) {
                if (k > bitK) {
                    res = res * 10 + nums[0];
                }else {
                    int index = count % (int)Math.pow(3, bitK);
                    res = res * 10 + nums[index];
                }
            }
        }
        System.out.println(res);
    }
}
