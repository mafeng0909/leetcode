package com.test.editor.cn.youzang;

/**
 * @author mafeng
 * @data 2020/10/11
 **/
public class Test101101 {
    public static void main(String[] args) {

    }

    public int[] fairCandySwap (int[] A, int[] B) {
        // write code here
        int diff = 0;
        boolean[] flag = new boolean[100001];
        for (int num : A) {
            diff -= num;
        }
        for (int num : B) {
            diff += num;
            flag[num] = true;
        }
        diff /= 2;
        for (int num : A) {
            int numB = num + diff;
            if (numB > 0 && numB < 100001 && flag[numB]) {
                return new int[]{num, num + diff};
            }
        }
        return null;
    }
}
