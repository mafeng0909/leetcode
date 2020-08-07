package com.niuke.editor.cn.netease;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/8/7
 **/
public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        if (sum % n != 0) {
            System.out.println(-1);
        }else {
            int target = sum / n;
            int count = 0;
            for (int i : arr) {
                if (i > target) {
                    count += (i - target) / 2;
                }else if (i < target) {
                    count += (target - i) / 2;
                }
            }
            int res = count % 2 == 0 ? count / 2 : -1;
            System.out.println(res);

            /*Arrays.sort(arr);
            int left = 0;
            int right = n - 1;
            while (left < right) {
                if (arr[left] == target) {
                    left++;
                    continue;
                }
                if (arr[right] == target) {
                    right--;
                    continue;
                }
                arr[left] += 2;
                arr[right] -= 2;
                count++;
            }
            System.out.println(count);*/
        }
    }
}
