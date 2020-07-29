//给定一个二叉树，返回它的 前序 遍历。 
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
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 322 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Java：二叉树的前序遍历
 * 
 * @author: mafeng
 * @data: 2020-07-29 09:40:34
 **/
public class P144BinaryTreePreOrderTraversal {
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
        public List<Integer> preOrderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                // 先不断向左遍历，讲左节点全部压入栈中
                while (cur != null) {
                    list.add(cur.val);
                    stack.push(cur);
                    cur = cur.left;
                }
                // 如果当前节点的左子树为空，则将栈顶元素弹出，向右遍历
                if (!stack.isEmpty()) {
                    cur = stack.pop();
                    cur = cur.right;
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