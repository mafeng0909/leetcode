package com.test.editor.cn;

import java.util.Arrays;

/**
 * @author mafeng
 * 排序算法
 *
 * @date 2020/7/20 14:56
 */
public class P3SortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 4, 9, 1};
//        quickSort(arr);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序
     * 方法：双指针（首尾）+ 递归
     * @param arr
     */
    public static void quickSort(int[] arr) {
        quickSorted(arr, 0, arr.length - 1);
    }

    public static void quickSorted(int[] arr, int left, int right) {
        // 双指针
        int start = left;
        int end = right;
        // 基准值（选择第一个值，也可以选择最后一个值）
        int keyValue = arr[start];

        while (start < end) {
            // 先从后向前查找
            while (start < end && keyValue <= arr[end]) {
                end--;
            }
            // 当找到一个比基准值小的数，交换位置
            if (keyValue > arr[end]) {
                arr[start] = arr[end];
                arr[end] = keyValue;
            }
            // 由于基准值交换到后面，再从前向后查找
            while (start < end && keyValue >= arr[start]) {
                start++;
            }
            // 当找到一个比基准值大的数，交换位置
            if (keyValue < arr[start]) {
                arr[end] = arr[start];
                arr[start] = keyValue;
            }
        }
        // 结束之后，基准值左边全是比其小的值；右边全是比其大的值
        if (start > left) {
            quickSorted(arr, left, start - 1);
        }
        if (end < right) {
            quickSorted(arr, end + 1, right);
        }
    }

    /**
     * 堆排序
     * @param arr
     */
    public static void heapSort(int[] arr) {
        int len = arr.length;
        // 将无序的数组构建成一个堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, len);
        }

        int temp = 0;
        // 构建完之后进行调整
        for (int j = len - 1; j >= 0; j--) {
            // 交换首尾位置
            temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            // 继续调整
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 调整堆
     * @param arr
     * @param i
     * @param len
     */
    public static void adjustHeap(int[] arr, int i, int len) {
        int temp = arr[i];
        // 因为堆是一种完全二叉树，所以i的左子节点为2 * i + 1
        for (int k = 2 * i + 1; k < len; k = k * 2 + 1) {
            // 右子节点的值 > 左子节点的值
            if (k + 1 < len && arr[k] < arr[k + 1]) {
                k = k + 1;
            }
            if (arr[i] < arr[k]) {
                arr[i] = arr[k];
                // 更新i
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
}
