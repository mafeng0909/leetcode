//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
//
// 返回:
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
//
// Related Topics 树 深度优先搜索

package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：路径总和 II
 * 分析：DFS
 *      对于树而言，临界条件都是 node == null
 *
 * @author mafeng
 */
public class P113PathSumIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(6);
        root.left = node1;
        root.right = node4;
        node1.left = node2;
        node1.right = node3;

        List<List<Integer>> lists = solution.pathSum(root, 7);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
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
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<Integer> pathList = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            dfs(root, sum, 0, pathList, result);
            return result;
        }

        public void dfs(TreeNode node, int targetSum, int totalSum,
                        List<Integer> pathList, List<List<Integer>> result) {
            if (node == null) {
                return;
            }
            totalSum += node.val;
            // 优化
            if (totalSum > targetSum) {
                totalSum -= node.val;
                return;
            }
            pathList.add(node.val);

            // 边界条件：如果 该节点是叶子节点
            if (node.left == null && node.right == null) {
                if (totalSum == targetSum) {
                    // 注意：一定要新建一个list对象，因为pathList对象会变
                    result.add(new ArrayList<>(pathList));
                }
            }

            dfs(node.left, targetSum, totalSum, pathList, result);
            dfs(node.right, targetSum, totalSum, pathList, result);
            // 回溯
            totalSum -= node.val;
            pathList.remove(pathList.size() - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
