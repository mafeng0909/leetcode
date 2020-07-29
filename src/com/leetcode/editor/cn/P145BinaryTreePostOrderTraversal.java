//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 353 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Java：二叉树的后序遍历
 * 
 * @author: mafeng
 * @data: 2020-07-29 09:58:25
 **/
public class P145BinaryTreePostOrderTraversal {
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
        public List<Integer> postOrderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            // 记录每次遍历最后一个访问的节点
            TreeNode lastView = null;
            while (cur != null || !stack.isEmpty()) {
                // 向左遍历，并压入栈
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                // 如果节点的左子节点为null，便取出栈顶元素，往右遍历
                if (!stack.isEmpty()) {
                    cur = stack.pop();
                    // 如果当前节点的右子节点为null，或者其右子节点已经被访问过
                    if (cur.right == null || cur.right == lastView) {
                        list.add(cur.val);
                        lastView = cur;
                        cur = null;
                    }else {
                        stack.push(cur);
                        cur = cur.right;
                    }
                }
            }
            return list;
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