package com.test.editor.cn.webank;

import java.util.*;

/**
 * @author mafeng
 * @data 2020/9/27
 **/
public class Test092703 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.println(getNum(arr));

    }

    public static int getNum(int[] arr) {
        int res = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (arr[i] <= arr[j] && arr[j] <= arr[k]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
