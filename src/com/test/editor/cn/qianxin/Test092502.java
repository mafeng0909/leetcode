package com.test.editor.cn.qianxin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author mafeng
 * @data 2020/9/25
 **/
public class Test092502 {
    public static void main(String[] args) {
        int[] tasks = {1, 1, 1, 2, 3, 3, 3};
        int n = 2;
        System.out.println(leastWorkTime(tasks, n));
    }

    public static int leastWorkTime(int[] tasks, int n) {
        int[] arr = new int[10];
        for (int task : tasks) {
            arr[task]++;
        }

        Pair[] pairs = new Pair[10];
        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(i, arr[i]);
        }

        List<Integer> res = new ArrayList<>();

        while (judgeEnd(pairs)) {
            Arrays.sort(pairs, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.count - o2.count;
                }
            });

            boolean flag = true;
            for (int i = pairs.length - 1; i >= 0; i--) {
                if (pairs[i].count > 0 && judge(res, pairs[i].index, n)) {
                    flag = false;
                    res.add(pairs[i].index);
                    pairs[i].count -= 1;
                    break;
                }
            }
            if (flag) {
                res.add(10);
            }
        }
        return res.size();
    }

    public static boolean judge(List<Integer> res, int index, int n) {
        if (res.size() - n < 0) {
            return true;
        }
        for (int i = res.size() - 1; i >= res.size() - n; i--) {
            if (res.get(i) == index) {
                return false;
            }
        }
        return true;
    }

    public static boolean judgeEnd(Pair[] pairs) {
        for (Pair pair : pairs) {
            if (pair.count != 0) {
                return true;
            }
        }
        return false;
    }

    public static class Pair {
        int index;
        int count;

        public Pair(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}
