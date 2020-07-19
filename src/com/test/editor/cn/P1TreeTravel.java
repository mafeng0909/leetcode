package com.test.editor.cn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的遍历
 *
 * @author mafeng
 * @date 2020/6/24 10:56
 */
public class P1TreeTravel {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.leftChild = node2;
        node1.rightChild = node3;
        node2.leftChild = node4;
        node2.rightChild = node5;
        node3.leftChild = node6;
        node3.rightChild = node7;
        // 前序遍历
//        preTravel(node1);
        // 中序遍历
//        inTravel(node1);
        // 后续遍历
//        postTravel(node1);
        // 层次遍历(宽度优先遍历)
//        levelTravel(node1);
        // 深度优先遍历
        dfsTree(node1);

    }

    /**
     * 前序遍历---非递归
     * 用栈来实现
     *
     * @param root
     */
    public static void preTravel(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !nodeStack.isEmpty()) {
            // 如果当前节点不为空，则往左遍历
            while (cur != null) {
                System.out.println(cur.data);
                nodeStack.push(cur);
                cur = cur.leftChild;
            }
            // 如果节点的左子节点为null，便取出栈顶元素，往右遍历
            if (!nodeStack.isEmpty()) {
                cur = nodeStack.pop();
                cur = cur.rightChild;
            }
        }
    }

    /**
     * 中序遍历---非递归
     * 用栈实现
     *
     * @param root
     */
    public static void inTravel(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !nodeStack.isEmpty()) {
            // 如果当前节点不为空，则往左遍历
            while (cur != null) {
                nodeStack.push(cur);
                cur = cur.leftChild;
            }
            // 如果节点的左子节点为null，便取出栈顶元素，往右遍历
            if (!nodeStack.isEmpty()) {
                cur = nodeStack.pop();
                System.out.println(cur.data);
                cur = cur.rightChild;
            }
        }
    }

    /**
     * 后序遍历---非递归
     * 用栈实现
     *
     * @param root
     */
    public static void postTravel(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode cur = root;
        // 记录每次遍历最后一个访问的节点
        TreeNode lastVisit = null;
        while (cur != null || !nodeStack.isEmpty()) {
            // 如果当前节点不为空，则往左遍历
            while (cur != null) {
                nodeStack.add(cur);
                cur = cur.leftChild;
            }
            // 如果节点的左子节点为null，便取出栈顶元素，往右遍历
            if (!nodeStack.isEmpty()) {
                cur = nodeStack.pop();
                // 如果当前节点的右子节点为null，或者其右子节点已经被访问过
                if (cur.rightChild == null || cur.rightChild == lastVisit) {
                    System.out.println(cur.data);
                    // 更新最后一个访问的节点
                    lastVisit = cur;
                    // 将该节点置空
                    cur = null;
                // 如果当前节点的右子节点不为null，或者其右子节点也没有被访问过
                }else {
                    // 将出站的元素继续压入栈
                    nodeStack.add(cur);
                    // 更新当前节点为其右子节点
                    cur = cur.rightChild;
                }
            }
        }
    }

    /**
     * 层级遍历   也叫二叉树的宽度优先遍历BFS --- 非递归
     * 用队列实现
     *
     * @param root
     */
    public static void levelTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode cur = nodeQueue.poll();
            System.out.println(cur.data);
            if (cur.leftChild != null) {
                nodeQueue.add(cur.leftChild);
            }
            if (cur.rightChild != null) {
                nodeQueue.add(cur.rightChild);
            }
        }
    }

    /**
     * 二叉树的深度优先遍历 DFS --- 非递归
     * 利用栈实现
     *
     * @param root
     */
    public static void dfsTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode cur = root;
        nodeStack.add(cur);
        while (!nodeStack.isEmpty()) {
            cur = nodeStack.pop();
            System.out.println(cur.data);
            if (cur.rightChild != null) {
                nodeStack.add(cur.rightChild);
            }
            if (cur.leftChild != null) {
                nodeStack.add(cur.leftChild);
            }
        }
    }

    static class TreeNode {
        public int data;
        public TreeNode leftChild;
        public TreeNode rightChild;

        public TreeNode(int data){
            this.data = data;
        }

    }
}
