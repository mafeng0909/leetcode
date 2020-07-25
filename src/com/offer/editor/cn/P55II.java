package com.offer.editor.cn;

/**
 * @author mafeng
 * 题目：判断某二叉树是否是平衡二叉树
 * 分析：平衡二叉树的特点是每个节点的左右子树的高度差<=1
 *      原问题与子问题：判断每个节点的左子树和右子树的高度差是否<=1
 *
 * @data 2020/7/25
 **/
public class P55II {
    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 判断根节点的左子树和右子树的高度差是否小于或等于1
        boolean flag = Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
        return flag && isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 求二叉树的深度
     *
     * @param root
     * @return
     */
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
