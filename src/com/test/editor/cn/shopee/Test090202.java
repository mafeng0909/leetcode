package com.test.editor.cn.shopee;

import java.util.*;

/**
 * @author mafeng
 * @data 2020/9/2
 **/
public class Test090202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> temp = new ArrayList<>();
        TreeSet<String> res = new TreeSet<>();
//        List<List<Integer>> res = new ArrayList<>();

        dfs(n, m, 1, temp, res);

        for (String re : res) {
            System.out.println(re);
        }
    }

    public static void dfs(int n, int target, int index, List<Integer> temp, TreeSet<String> res) {
        if (target == 0) {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : temp) {
                sb.append(integer);
                sb.append(" ");
            }
            res.add(sb.toString());
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i <= n; i++) {
            temp.add(i);
            dfs(n, target - i, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
