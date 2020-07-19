//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 
//
// 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化
//为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树

package com.leetcode.editor.cn;

import java.util.ArrayList;

/**
 * Java：序列化和反序列化二叉搜索树
 * @author mafeng
 */
public class P449SerializeAndDeserializeBst{
    public static void main(String[] args) {
        // TO TEST
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(10);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(15);

        Codec codec = new Codec();
        codec.insertTree(root, node1);
        codec.insertTree(root, node2);
        codec.insertTree(root, node3);
        codec.insertTree(root, node4);
        codec.insertTree(root, node5);
        codec.insertTree(root, node6);

        String serialize = codec.serialize(root);
        System.out.println(serialize);

        TreeNode treeNode = codec.deserialize(serialize);
        String serialize2 = codec.serialize(treeNode);
        System.out.println(serialize2);
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
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder data = new StringBuilder();
            preOrder(root, data);
            return data.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("".equals(data) || data.length() == 0) {
                return null;
            }
            ArrayList<TreeNode> treeNodes = new ArrayList<>();
            int val = 0;
            for (int i = 0; i < data.length(); i++) {
                if (data.charAt(i) == '#') {
                    treeNodes.add(new TreeNode(val));
                    val = 0;
                }else {
                    val = val * 10 + (data.charAt(i) - '0');
                }
            }
            for (int i = 1; i < treeNodes.size(); i++) {
                insertTree(treeNodes.get(0), treeNodes.get(i));
            }
            return treeNodes.get(0);
        }

        /**
         * 前序遍历
         * @param node
         * @param data
         */
        public void preOrder(TreeNode node, StringBuilder data) {
            if (node == null) {
                return;
            }
            data.append(node.val);
            data.append("#");
            preOrder(node.left, data);
            preOrder(node.right, data);
        }

        /**
         * BST插入
         * @param root
         * @param node
         */
        public void insertTree(TreeNode root, TreeNode node) {
            if (root.val > node.val) {
                if (root.left == null) {
                    root.left = node;
                }else {
                    insertTree(root.left, node);
                }
            }else {
                if (root.right == null) {
                    root.right = node;
                }else {
                    insertTree(root.right, node);
                }
            }
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));
    //leetcode submit region end(Prohibit modification and deletion)

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }
}