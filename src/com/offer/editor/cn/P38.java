package com.offer.editor.cn;

import java.util.*;

/**
 * @author mafeng
 * 题目：字符串的排列组合
 * 分析：使用交换 + 剪枝
 *
 * @date 2020/7/14 22:22
 */
public class P38 {
    public static void main(String[] args) {
        String[] strings = permutation("abc");
        System.out.println(Arrays.toString(strings));
    }

    public static String[] permutation(String s) {
        char[] chars = s.toCharArray();
        List<String> res = new ArrayList<>();
        dfs(chars, 0, res);
        return res.toArray(new String[0]);
    }

    private static void dfs(char[] chars, int index, List<String> res) {
        // 临界条件
        if (index == chars.length - 1) {
            res.add(String.valueOf(chars));
            return;
        }
        // set用来对每一层进行剪枝，即每一层都有一个set集合
        Set<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            // 剪枝
            if (!set.add(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            swap(chars, i, index);
            dfs(chars, index + 1, res);
            // 回溯
            swap(chars, i, index);
        }
    }

    /**
     * 进行索引位置互换
     * @param chars
     * @param i
     * @param j
     */
    private static void swap(char[] chars, int i, int j) {
        char item = chars[i];
        chars[i] = chars[j];
        chars[j] = item;
    }
}
