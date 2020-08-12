package com.test.editor.cn.netease;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/8/8
 **/
public class Test080802 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        if (m == n) {
            for (int i : arr) {
                System.out.print(i);
                System.out.print(" ");
            }
        }else {
            int[] newArr = new int[n + 1];
            List<Integer> res = new ArrayList<>();

            // 标记位置
            Arrays.fill(newArr, 1);
            for (int value : arr) {
                newArr[value] = 0;
            }

            int arrIndex = 0;
            for (int i = 1; i < newArr.length; i++) {
                if (newArr[i] == 0) {
                    continue;
                }
                if (newArr[i] == 1) {
                    if (i < arr[arrIndex]) {
                        res.add(i);
                    }
                    // 如果该数小于m数组的元素
                    if (i > arr[arrIndex]) {
                        for (int j = arrIndex; j < arr.length; j++) {
                            if (i > arr[j]) {
                                res.add(arr[j]);
                            }else {
                                arrIndex = j;
                                break;
                            }
                        }
                        res.add(i);
                    }
                }
            }
            // 如果arr还有元素没有装入
            while (arrIndex < arr.length) {
                res.add(arr[arrIndex]);
                arrIndex++;
            }
            for (int i = 0; i < n; i++) {
                System.out.print(res.get(i));
                System.out.print(" ");
            }
        }
    }
}
