package com.test.editor.cn.didi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/13
 **/
public class Test091302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        boolean[] res = new boolean[t];
        for (int i = 0; i < t; i++) {
            sc.nextLine();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            TreeNode[] nodes = new TreeNode[n];
            for (int c = 0; c < nodes.length; c++) {
                nodes[c] = new TreeNode(c);
            }
            for (int j = 0; j < m; j++) {
                sc.nextLine();
                int a = sc.nextInt();
                int b = sc.nextInt();
                int pay = sc.nextInt();
                if (pay <= k) {
                    TreeNode node = new TreeNode(b - 1);
                    TreeNode cur = nodes[a - 1];
                    while (cur.next != null) {
                        cur = cur.next;
                    }
                    cur.next = node;
                }
            }
            res[i] = judge(nodes);
        }
        // 输出
        for (boolean re : res) {
            if (re) {
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

    public static boolean judge(TreeNode[] nodes) {
        boolean[] visited = new boolean[nodes.length];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(nodes[0]);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            visited[poll.val] = true;
            while (poll.next != null) {
                queue.add(poll.next);
                poll = poll.next;
            }
        }
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public static class TreeNode {
        int val;
        TreeNode next;

        public TreeNode (int val) {
            this.val = val;
        }
    }
}
