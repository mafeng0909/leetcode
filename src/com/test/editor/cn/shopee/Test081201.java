package com.test.editor.cn.shopee;

import java.util.*;

/**
 * @author mafeng
 * @data 2020/8/12
 **/
public class Test081201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*Queue<Integer> queue = new PriorityQueue<>();
        String s = sc.nextLine();
        String[] s1 = s.trim().split(" ");
        for (String s2 : s1) {
            queue.add(Integer.valueOf(s2));
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll());
            System.out.print(" ");
        }*/

//        String s = sc.nextLine();
//        String[] s1 = s.trim().split(" ");
//        int[] arr = new int[s1.length];
//        for (int i = 0; i < s1.length; i++) {
//            arr[i] = Integer.parseInt(s1[i]);
//        }

        int[] arr = {10, 2, 5, 7, 12, 3, 8};
        createTree(arr);
    }

    /**
     * 创建平衡二叉树
     *
     * @param arr
     */
    public static void createTree(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        TreeNode root = new TreeNode();
        root.value = arr[0];
        for (int i = 1; i < arr.length; i++) {
            adjustTree(root, arr[i]);
        }

        inOrder(root);

    }

    /**
     * 调整平衡二叉树
     *
     * @param root
     * @param target
     */
    public static void adjustTree(TreeNode root, int target) {
        if (root.value > target) {
            if (root.left != null) {
                adjustTree(root.left, target);
            }else {
                root.left = new TreeNode(target);
            }
        }else {
            if (root.right != null) {
                adjustTree(root.right, target);
            }else {
                root.right = new TreeNode(target);
            }
        }
    }

    public static void inOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            System.out.print(node.value);
            System.out.print(" ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.value = val;
            this.left = null;
            this.right = null;
        }
    }
}
