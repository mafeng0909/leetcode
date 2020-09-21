package com.test.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author mafeng
 * @data 2020/9/21
 **/
public class Test092101 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 3, 2};
        int[] arr2 = {1, 5, 8};
        List<Integer> list = find(arr);
        for (Integer integer : list) {
            System.out.print(integer);
            System.out.print(" ");
        }
    }

    public static List<Integer> find(int[] arr) {
        if (arr.length == 0) {
            return new ArrayList<>();
        }
        if (arr.length < 4) {
            int max = arr[0];
            for (int i : arr) {
                max = Math.max(max, i);
            }
            List<Integer> res = new ArrayList<>();
            res.add(max);
            return res;
        }else {
            Queue<Integer> queue = new PriorityQueue<>();
            int count = 0;
            int index = 0;
            while (index < arr.length) {
                if (count < 4) {
                    queue.add(arr[index]);
                    count++;
                }else {
                    if (!queue.isEmpty() && queue.peek() < arr[index]) {
                        queue.poll();
                        queue.add(arr[index]);
                    }
                }
                index++;
            }
            List<Integer> res = new ArrayList<>();
            while (!queue.isEmpty()) {
                res.add(queue.poll());
            }
            return res;
        }
    }
}
