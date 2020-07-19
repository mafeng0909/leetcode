//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索

package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Java：二叉树的右视图
 * @author mafeng
 */
public class P199BinaryTreeRightSideView{
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> viewList = new ArrayList<>();
            // 存储节点
            Queue<TreeNode> queueNode = new LinkedList<>();
            // 存储每个节点的高度
            Queue<Integer> queueDepth = new LinkedList<>();

            if (root != null) {
                queueNode.add(root);
                queueDepth.add(0);
            }

            while (!queueNode.isEmpty() && !queueDepth.isEmpty()) {
                // 取出queue中最前面的节点以及对应的高度
                Integer depth = queueDepth.poll();
                TreeNode node = queueNode.poll();
                // 如果viewList的长度与节点的高度相等，则直接加入到viewList的末尾(即索引位置为depth)
                if (viewList.size() == depth) {
                    viewList.add(node.val);
                }else {
                    // 否则，覆盖索引为depth的元素(因为其不是每层最右边的一个节点)
                    viewList.set(depth, node.val);
                }

                if (node.left != null) {
                    queueNode.add(node.left);
                    queueDepth.add(depth + 1);
                }
                if (node.right != null) {
                    queueNode.add(node.right);
                    queueDepth.add(depth + 1);
                }
            }
            return viewList;
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