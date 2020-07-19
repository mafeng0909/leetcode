//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例:
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
//
// Related Topics 链表

package com.leetcode.editor.cn;

/**
 * Java：两两交换链表中的节点
 *
 * @author mafeng
 */
public class P24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public ListNode swapPairs(ListNode head) {
            int len = getListNodeLen(head);
            int num = len / 2;
            if (num == 0) {
                return head;
            }
            // 如果num不为0，则说明链表肯定需要翻转，即翻转后的头节点变为head.next，提前记录，便于返回结果
            ListNode result = head.next;
            // 前驱节点
            ListNode pre = new ListNode(0);
            pre.next = head;
            // 记录已翻转的对数
            int count = 1;
            while (count <= num) {
                // 记录当前需要翻转的两个节点
                ListNode left = pre.next;
                ListNode right = pre.next.next;
                // 进行翻转
                left.next = right.next;
                right.next = left;
                pre.next = right;
                // 更新前驱节点
                pre = pre.next.next;
                // 更新翻转的对数
                count++;
            }
            return result;
        }

        /**
         * 计算链表长度
         * @param root
         * @return
         */
        public int getListNodeLen(ListNode root) {
            int count = 0;
            while (root != null) {
                count++;
                root = root.next;
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
