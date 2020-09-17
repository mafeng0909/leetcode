package com.test.editor.cn.netease;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/12
 **/
public class Test091201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        TreeNode[] nodes = new TreeNode[m + 1];
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new TreeNode();
        }

        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] strings = s.trim().split(" ");
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[2]);
            if ("left".equals(strings[1])) {
                nodes[a].left = nodes[b];
            }
            if ("right".equals(strings[1])) {
                nodes[a].right = nodes[b];
            }
        }

        int count = 0;
        for (int i = 1; i < nodes.length; i++) {
            TreeNode left = nodes[i].left;
            TreeNode right = nodes[i].right;
            if (left == null || right == null) {
                continue;
            }
            if (left.left == null && left.right == null && right.left == null && right.right == null) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static class TreeNode {
        TreeNode left;
        TreeNode right;

        public TreeNode() {

        }
    }
}
