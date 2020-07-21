package com.test.editor.cn;

/**
 * kmp算法：解决字符串查找问题
 * 题目：已有字符串“BBC ABCDAB ABCDABCDABDE”
 *      试问ABCDABD是否在其中，并求其开始的索引
 *
 * @author mafeng
 * @date 2020/6/24 16:01
 */
public class P2KMPAlgorithm {
    public static void main(String[] args) {
        String str = "BBC ABCDAB ABCDABCDABDE";
        String target = "ABCDABD";
        int index = kmpSearch(str, target, kmpNext(target));
        System.out.println(index);
    }

    /**
     * kmp算法
     * 核心公式：j = next[j - 1]
     *
     * @param str
     * @param target
     * @param next
     * @return
     */
    public static int kmpSearch(String str, String target, int[] next) {
        for (int i = 0, j = 0; i < str.length(); i++) {
            // 遍历时，如果一直没有元素和第一个元素相等时，此while一直不会进入
            if (j > 0 && str.charAt(i) != target.charAt(j)) {
                // 如果比对的时候不相等，则更新j的值（利用next数组）
                j = next[j - 1];
            }
            if (str.charAt(i) == target.charAt(j)) {
                j++;
            }
            if (j == target.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    /**
     * 生成目标字符串的next数组，即部分匹配值表
     * 注：部分匹配值 = 前缀和后缀的最长共有元素的长度
     * 例如：A -> 0
     *      AB -> 0
     *      ABC -> 0
     *      ABCD -> 0
     *      ABCDA -> 1
     *      ABCDAB -> 2
     *      ABCDABD -> 0
     *
     * @param target
     * @return
     */
    public static int[] kmpNext(String target) {
        int[] next = new int[target.length()];
        for (int i = 1, j = 0; i < target.length(); i++) {
            // 遍历时，如果一直没有元素和第一个元素相等时，此while一直不会进入
            while (j > 0 && target.charAt(j) != target.charAt(i)) {
                // 最重要的一个公式！！！
                j = next[j - 1];
            }
            if (target.charAt(j) == target.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
