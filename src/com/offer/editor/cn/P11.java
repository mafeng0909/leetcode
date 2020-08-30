package com.offer.editor.cn;

/**
 * @author mafeng
 * @data 2020/8/29
 **/
public class P11 {
    public static void main(String[] args) {

    }

    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        if (numbers[left] < numbers[right]) {
            return numbers[left];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 说明右边是递增（或相等）的，即最小数在左边
            if (numbers[mid] < numbers[right]) {
                right = mid;
            // 说明左边是递增（或相等）的，即最小数在右边
            }else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            // 可能是 2 1 2 2 2 或 2 2 2 1 2
            }else {
                right--;
            }
        }
        return numbers[left];
    }
}
