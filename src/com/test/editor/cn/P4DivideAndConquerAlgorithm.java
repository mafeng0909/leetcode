package com.test.editor.cn;

/**
 * @author mafeng
 * 分治算法：将原问题分为多个子问题，并且问题之间并没有关联性，相互独立
 *
 * @data 2020/7/21
 **/
public class P4DivideAndConquerAlgorithm {
    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }

    /**
     * 汉诺塔
     * 分析：不管有多少个盘，都可以视为只有两个盘，最下面一个，上面所有（num - 1）视为一个
     *      因此每个问题都可以这样解决：
     *          1 将上面那个盘先移到中间柱子上
     *          2 再将下面那个盘一到目标柱子上，
     *          3 最后将中间柱子上的那个盘移到目标柱子上
     *
     * @param num
     * @param a
     * @param b
     * @param c
     */
    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第" + num + "个盘子：" + a + "->" + c);
        }else {
            // 1、现将上面第一个盘子移动到中间柱子上
            hanoiTower(num - 1, a, c, b);
            // 2、将下面那个盘子移动到目标柱子上
            System.out.println("第" + num + "个盘子：" + a + "->" + c);
            // 3、现将中间柱子上的那个盘子移动到目标柱子上
            hanoiTower(num - 1, b, a, c);
        }
    }
}
