//给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。 
//
// 说明： 
//你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 1 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 3 
//
// 进阶： 
//如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？ 
// Related Topics 树 二分查找 
// 👍 250 👎 0


package com.leetcode.editor.cn;
/**
 * Java：二叉搜索树中第K小的元素
 * 
 * @author: mafeng
 * @data: 2020-08-01 19:38:51
 **/
public class P230KthSmallestElementInABst{
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
        private static int res;
        private static int num;

        public int kthSmallest(TreeNode root, int k) {
            num = k;
            inOrder(root);
            return res;
        }

        /**
         * 中序遍历
         * 由于是二叉搜索树，所以中序遍历的数是从小到大的顺序输出
         * 在输出的位置加一个计数，当减为0，则为第K小的元素
         *
         * @param root
         */
        public static void inOrder(TreeNode root) {
            if (root == null || num <= 0) {
                return;
            }
            inOrder(root.left);
            if (--num == 0) {
                res = root.val;
            }
            inOrder(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}