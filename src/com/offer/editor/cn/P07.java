package com.offer.editor.cn;

import java.util.Arrays;

/**
 * @author mafeng
 * @data 2020/8/28
 **/
public class P07 {
    public static void main(String[] args) {

    }

    public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder.length == 0 || preOrder.length != inOrder.length) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[0]);
        for (int i = 0; i < inOrder.length; i++) {
            if (root.val == inOrder[i]) {
                root.left = buildTree(Arrays.copyOfRange(preOrder, 1, i + 1),
                        Arrays.copyOfRange(inOrder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preOrder, i + 1, preOrder.length),
                        Arrays.copyOfRange(inOrder, i + 1, inOrder.length));
            }
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
