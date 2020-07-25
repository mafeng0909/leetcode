package com.offer.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：和为s的连续正数序列
 * 分析：双指针
 *
 * @author mafeng
 * @data 2020/7/25
 **/
public class P57II {
    public static void main(String[] args) {
        List<List<Integer>> list = findContinuousSequence(15);
        for (List<Integer> integerList : list) {
            System.out.println(Arrays.toString(integerList.toArray()));
        }
    }

    public static List<List<Integer>> findContinuousSequence(int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // 特殊情况
        if (target < 3) {
            list.add(target);
            result.add(list);
            return result;
        }
        int start = 1;
        int end = 2;
        // 保证往下叠加有可能等于target
        while (start < (target + 1) / 2) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            if (sum == target) {
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                result.add(new ArrayList<>(list));
                list.clear();
                start++;
            }else if (sum < target) {
                end++;
            }else {
                start++;
            }
        }
        return result;
    }
}
