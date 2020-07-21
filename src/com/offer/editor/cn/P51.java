package com.offer.editor.cn;

/**
 * @author mafeng
 * 题目：数组中的逆序对
 * 分析：利用归并排序
 *      在合并时，当前一个数组的元素大于后一个数组的元素时，更新count
 *      count += mid + 1 - start
 *
 * @data 2020/7/21
 **/
public class P51 {

    public static int count = 0;

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7};
        reversePairs(arr);
        System.out.println(count);
    }

    public static int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    /**
     * 归并排序
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] res = new int[right - left + 1];
        int index = 0;
        int indexLeft = left;
        int indexRight = mid + 1;
        while (indexLeft <= mid && indexRight <= right) {
            if (arr[indexLeft] < arr[indexRight]) {
                res[index++] = arr[indexLeft++];
            }else {
                count += mid + 1 - indexLeft;
                res[index++] = arr[indexRight++];
            }
        }
        while (indexLeft <= mid) {
            res[index++] = arr[indexLeft++];
        }
        while (indexRight <= right) {
            res[index++] = arr[indexRight++];
        }
        for (int i : res) {
            arr[left++] = i;
        }
    }
}
