package com.offer.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author mafeng
 * 题目：最小的k个数
 * 分析：利用堆排序
 *      或者直接对数组进行快排，输出前k个数即可
 *
 * @date 2020/7/14 23:30
 */
public class P40 {
    public static void main(String[] args) {

    }

    public int[] getLeastNumbers(int[] arr, int k) {
        // 大顶堆
        Queue<Integer> queue = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int num : arr) {
            if (queue.size() < k) {
                queue.add(num);
            }else {
                if (!queue.isEmpty() && queue.peek() > num) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }
        int len = queue.size();
        int[] nums = new int[len];
        while (!queue.isEmpty()) {
            nums[len - 1] = queue.poll();
            len--;
        }
        return nums;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.add(i);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
