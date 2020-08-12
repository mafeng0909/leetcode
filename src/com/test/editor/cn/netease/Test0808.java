package com.test.editor.cn.netease;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/8/8
 **/
public class Test0808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int count = 0;
//        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
            int k = sc.nextInt();
            count += judge(k);
        }

        System.out.println(count);
    }

    public static int judge(int i) {
        if (i == 1) {
            return 0;
        }
        if (i <= 3) {
            return 1;
        }
        return i / 2;
    }
}
