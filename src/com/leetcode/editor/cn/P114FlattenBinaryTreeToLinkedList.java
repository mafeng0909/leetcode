//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索

package com.leetcode.editor.cn;
/**
 * Java：二叉树展开为链表
 * 分析：将每个节点都分为左子树和右子树进行递归
 *      边界条件：当一个节点没有左子树和右子树时，将其赋给last节点
 *
 * @author mafeng
 */
public class P114FlattenBinaryTreeToLinkedList{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    static class Solution {
        public void flatten(TreeNode root) {
            TreeNode last = new TreeNode(0);
            preOrder(root, last);
        }

        public void preOrder(TreeNode root, TreeNode last) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                last.right = root;
                return;
            }
            // 将其左右子节点均备份
            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;
            root.left = null;
            TreeNode leftLast = new TreeNode(0);
            TreeNode rightLast = new TreeNode(0);
            if (leftNode != null) {
                preOrder(leftNode, leftLast);
                root.right = leftNode;
                last.right = leftLast.right;
            }
            if (rightNode != null) {
                preOrder(rightNode, rightLast);
                if (leftLast.right != null) {
                    leftLast.right.right = rightNode;
                }
                last.right = rightLast.right;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}