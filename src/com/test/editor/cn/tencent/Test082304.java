package com.test.editor.cn.tencent;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/8/23
 **/
public class Test082304 {

    private static int[] arr = new int[5005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(mStep(0, n - 1, 0));
    }

    public static int mStep(int l, int r, int gMin) {
        if (l == r) {
            return 1;
        }
        int i = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int l2 = 0;
        int r2 = 0;

        for (i = l; i <= r; i++) {
            if (min > arr[i] - gMin) {
                min = arr[i] -gMin;
            }
        }
        for (i = l; i <= r; i++) {
            if (arr[i] > gMin) {
                l2 = i;
                r2 = i;
                while (arr[r2] > gMin) {
                    r2++;
                }
                sum += mStep(l2, r2 - 1, gMin + min);
                i = r2 - 1;
            }
        }
        return Math.min(sum + min, r - l + 1);
    }
}
