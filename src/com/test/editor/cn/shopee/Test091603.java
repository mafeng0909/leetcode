package com.test.editor.cn.shopee;

import java.util.*;

/**
 * @author mafeng
 * @data 2020/9/16
 **/
public class Test091603 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        int[] preOrder = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            preOrder[i] = Integer.parseInt(s[i]);
        }

        TreeNode root = new TreeNode(preOrder[0]);
        for (int i = 1; i < preOrder.length; i++) {
            createTree(root, preOrder[i]);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left == null && poll.right == null) {
                res.add(poll.val);
            }
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }

        Collections.sort(res);
        for (Integer re : res) {
            System.out.print(re);
            System.out.print(" ");
        }
    }

    public static void createTree(TreeNode root, int val) {
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            }else {
                createTree(root.left, val);
            }
        }else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            }else {
                createTree(root.right, val);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
