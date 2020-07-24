package com.offer.editor.cn;

/**
 * @author mafeng
 * 题目：求二叉树的深度
 * 分析：递归
 *
 * @data 2020/7/24
 **/
public class P55 {
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
