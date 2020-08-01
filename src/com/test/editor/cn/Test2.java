package com.test.editor.cn;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/7/31
 **/
public class Test2 {

    private static int index = -1;

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String numString = sc.nextLine();
        String targetString = sc.nextLine();
        int num = Integer.parseInt(s);
        // 越界判断
        if (num > 0) {
            int target = Integer.parseInt(targetString);
            String[] strings = numString.trim().split(" ");
            int[] nums = new int[num];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }
            search(nums, 0, nums.length, target);

            System.out.println(index);
        }*/
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num > 0) {
            int[] nums = new int[num];
            scanner.nextLine();
            for (int i = 0; i < num; i++) {
                nums[i] = scanner.nextInt();
            }
            scanner.nextLine();
            int target = scanner.nextInt();
            search(nums, 0, nums.length, target);
            System.out.println(index);
        }
    }

    public static void search(int[] nums, int left, int right, int target) {
        if (left > right) {
            return;
        }
        int mid = left + (right - left) / 2;
        if (target > nums[mid]) {
            search(nums, mid + 1, right, target);
        }else if (nums[mid] > target) {
            search(nums, left, mid - 1, target);
        }else {
            index = mid;
        }
    }
}
