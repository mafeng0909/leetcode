//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组
// 👍 553 👎 0

package com.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Java：从前序与中序遍历序列构造二叉树
 * 分析：分治算法
 *      前序遍历的死一个元素就是根节点，所以在中序遍历中根节点的左右两边分别是左子树和右子树
 *
 * @author mafeng
 */
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal{
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // 临界条件
            if (preorder.length == 0 || inorder.length == 0) {
                return null;
            }
            if (preorder.length != inorder.length) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[0]);

            for (int i = 0; i < inorder.length; i++) {
                if (preorder[0] == inorder[i]) {
                    root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1),
                            Arrays.copyOfRange(inorder, 0, i));
                    root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length),
                            Arrays.copyOfRange(inorder, i + 1, inorder.length));
                }
            }
            return root;
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
