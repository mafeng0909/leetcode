//给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 num
//s[i] 的元素的数量。
//
// 示例:
//
// 输入: [5,2,6,1]
//输出: [2,1,1,0]
//解释:
//5 的右侧有 2 个更小的元素 (2 和 1).
//2 的右侧仅有 1 个更小的元素 (1).
//6 的右侧有 1 个更小的元素 (1).
//1 的右侧有 0 个更小的元素.
//
// Related Topics 排序 树状数组 线段树 二分查找 分治算法

package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：计算右侧小于当前元素的个数
 * @author mafeng
 */
public class P315CountOfSmallerNumbersAfterSelf{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        int[] nums = {5, 2, 6, 1};
        List<Integer> list = solution.countSmaller(nums);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public List<Integer> countSmaller(int[] nums) {
            int len = nums.length;
            int[] count = new int[len];
            ArrayList<TreeNode> treeNodes = new ArrayList<>();
            // 将nums的元素逆序构成节点
            for (int i = len - 1; i >= 0; i--) {
                treeNodes.add(new TreeNode(nums[i]));
                count[i] = 0;
            }
            // 按照逆序进行插入二叉树
            for (int i = 1; i < treeNodes.size(); i++) {
                insert(treeNodes.get(0), treeNodes.get(i), i, count);
            }
            // 整理结果
            List<Integer> result = new ArrayList<>();
            for (int i = count.length - 1; i >= 0; i--) {
                result.add(count[i]);
            }
            return result;

        }

        public void insert(TreeNode root, TreeNode node, int i, int[] count) {
            // 小于或等于的节点均插入到左子树
            if (node.val <= root.val) {
                root.count++;
                if (root.left == null) {
                    root.left = node;
                }else {
                    insert(root.left, node, i, count);
                }
            }else {
                // 注意：此处不更新节点的count值，全程我们只当有比root节点小的节点出现的时候，才更新root节点的count
                count[i] += root.count + 1;
                if (root.right == null) {
                    root.right = node;
                }else {
                    insert(root.right, node, i, count);
                }
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    static class TreeNode{
        int val;
        int count;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.count = 0;
            this.left = null;
            this.right = null;
        }
    }
}
