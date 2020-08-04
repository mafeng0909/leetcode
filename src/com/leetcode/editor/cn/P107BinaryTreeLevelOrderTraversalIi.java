//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 277 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Java：二叉树的层次遍历 II
 * 
 * @author: mafeng
 * @data: 2020-08-04 09:30:44
 **/
public class P107BinaryTreeLevelOrderTraversalIi{
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
     *     TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {
        /**
         * 方法一：新建一个queue来存储高度
         *
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            Queue<Integer> depthQueue = new LinkedList<>();
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            if (root != null) {
                nodeQueue.add(root);
                depthQueue.add(0);
            }
            while (!nodeQueue.isEmpty() && !depthQueue.isEmpty()) {
                TreeNode curNode = nodeQueue.poll();
                Integer curDepth = depthQueue.poll();
                if (res.size() == curDepth) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curNode.val);
                    res.add(list);
                }else {
                    List<Integer> list = res.get(curDepth);
                    list.add(curNode.val);
                    res.set(curDepth, list);
                }
                if (curNode.left != null) {
                    nodeQueue.add(curNode.left);
                    depthQueue.add(curDepth + 1);
                }
                if (curNode.right != null) {
                    nodeQueue.add(curNode.right);
                    depthQueue.add(curDepth + 1);
                }
            }
            List<List<Integer>> newList = new ArrayList<>();
            for (int i = res.size() - 1; i >= 0; i--) {
                newList.add(res.get(i));
            }
            return newList;
         }

        /**
         * 方法二：直接利用队列来简介记录高度
         *
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrderBottom2(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                // 从侧面记录每一层的节点个数
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                res.add(0, list);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}