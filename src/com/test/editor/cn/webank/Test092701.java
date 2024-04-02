package com.test.editor.cn.webank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/27
 **/
public class Test092701 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            sc.nextLine();
            int num = sc.nextInt();
            if (num <= arr[0]) {
                res[i] = arr[0];
            }else if (num >= arr[n - 1]) {
                res[i] = arr[n - 1];
            }else {
                int index = binarySearch(arr, num);
                res[i] = arr[index];
            }
        }
        for (int re : res) {
            System.out.println(re);
        }
    }



    public static int binarySearch(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == num) {
                return mid;
            }else if (arr[mid] > num) {
                right = mid - 1;
            }else if (arr[mid] < num) {
                left = mid;
            }
        }
        return Math.abs(arr[left] - num) > Math.abs(arr[right] - num) ? right : left;
    }
}
