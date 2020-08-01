//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树

package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：二叉树的最近公共祖先
 * @author mafeng
 */
public class P236LowestCommonAncestorOfABinaryTree{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        root.left = node5;
        root.right = node2;
        node5.left = node6;
        node5.right = node3;
        node3.left = node7;
        node3.right = node4;
        node2.left = node1;
        node2.right = node8;

        TreeNode commonAncestor = solution.lowestCommonAncestor1(root, node5, node4);
//        TreeNode commonAncestor1 = solution.lowestCommonAncestor1(root, node2, node3);
        if (commonAncestor != null) {
            System.out.println("commonAncestor: " + commonAncestor.val);
        }

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
         * 第一种方法：分开dfs求出路径
         *
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> resultP = new ArrayList<>();
            List<TreeNode> resultQ = new ArrayList<>();
            dfs(root, p, false, new ArrayList<TreeNode>(), resultP);
            dfs(root, q, false, new ArrayList<TreeNode>(), resultQ);
            System.out.print("p -> index : ");
            for (TreeNode treeNode : resultP) {
                System.out.print(treeNode.val + "->");
            }
            System.out.println();
            System.out.print("q -> index : ");
            for (TreeNode treeNode : resultQ) {
                System.out.print(treeNode.val + "->");
            }
            System.out.println();
            int len = Math.min(resultP.size(), resultQ.size());
            while (resultP.get(len - 1) != resultQ.get(len - 1)) {
                len--;
            }
            return resultP.get(len - 1);
//            for (int i = 0; i < len; i++) {
//                if (resultP.get(i) != resultQ.get(i)) {
//                    System.out.println(resultP.get(i - 1).val);
//                    return resultP.get(i - 1);
//                }
//            }
//            return null;
        }

        /**
         * 查询节点的路径
         * @param root
         * @param targetNode
         * @param flag
         * @param path
         */
        public void dfs(TreeNode root, TreeNode targetNode, boolean flag,
                        List<TreeNode> path, List<TreeNode> result) {
            if (flag) {
                return;
            }
            path.add(root);
            if (root.val == targetNode.val) {
                flag = true;
                result.addAll(path);
            }
            if (root.left != null) {
                dfs(root.left, targetNode, flag, path, result);
            }
            if (root.right != null) {
                dfs(root.right, targetNode, flag, path, result);
            }
            // 回溯
            path.remove(path.size() - 1);
        }

        /**
         * 第二种方法：两个节点一起dfs求出路径
         *
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> resultP = new ArrayList<>();
            List<TreeNode> resultQ = new ArrayList<>();
            dfs1(root, p, q, false, false, new ArrayList<TreeNode>(), resultP, resultQ);
            System.out.print("p -> index : ");
            for (TreeNode treeNode : resultP) {
                System.out.print(treeNode.val + "->");
            }
            System.out.println();
            System.out.print("q -> index : ");
            for (TreeNode treeNode : resultQ) {
                System.out.println(treeNode.val + "->");
            }
            System.out.println();
            int len = Math.min(resultP.size(), resultQ.size());
            while (resultP.get(len - 1) != resultQ.get(len - 1)) {
                len--;
            }
            return resultP.get(len - 1);
        }
        /**
         *
         * @param root
         * @param targetP
         * @param targetQ
         * @param flagP
         * @param flagQ
         * @param path
         * @param resultP
         * @param resultQ
         */
        public void dfs1(TreeNode root, TreeNode targetP, TreeNode targetQ, boolean flagP, boolean flagQ,
                         List<TreeNode> path, List<TreeNode> resultP, List<TreeNode> resultQ) {
            if (root == null) {
                return;
            }
            if (flagP && flagQ) {
                return;
            }
            path.add(root);
            if (root == targetP) {
                flagP = true;
                resultP.addAll(path);
            }
            if (root == targetQ) {
                flagQ = true;
                resultQ.addAll(path);
            }
            dfs1(root.left, targetP, targetQ, flagP, flagQ, path, resultP, resultQ);
            dfs1(root.right, targetP, targetQ, flagP, flagQ, path, resultP, resultQ);

            // 回溯
            path.remove(path.size() - 1);
        }

        /**
         * 第三种：分治算法
         *
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor3(root.left, p, q);
            TreeNode right = lowestCommonAncestor3(root.right, p, q);
            // 如果两边都找到了值，则说明两个节点分布在两边，最近公共祖先为根节点
            if (left != null && right != null) {
                return root;
                // 如果只有左边有值，说明两个节点都在左边，最近公共祖先为left节点
            }else if (left != null) {
                return left;
                // 如果只有右边有值，说明两个节点都在右边，最近公共祖先为right节点
            }else if (right != null) {
                return right;
            }
            return null;
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