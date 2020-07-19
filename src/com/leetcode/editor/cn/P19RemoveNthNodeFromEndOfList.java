//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例：
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//
//
// 说明：
//
// 给定的 n 保证是有效的。
//
// 进阶：
//
// 你能尝试使用一趟扫描实现吗？
// Related Topics 链表 双指针

package com.leetcode.editor.cn;

/**
 * Java：删除链表的倒数第N个节点
 * @author mafeng
 */
public class P19RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int len = listNodeLen(head);
            int index = len - n;
            // 如果该索引的位置是0， 则直接返回头节点的下一个节点
            if (index == 0) {
                return head.next;
            }
            int count = 0;
            ListNode pre = new ListNode(0);
            // 定义前驱节点pre
            pre.next = head;
            while (pre.next != null) {
                if (count == index) {
                    // 如果找到了，则将该节点的后一个元素接在前驱节点的后面
                    pre.next = pre.next.next;
                    break;
                }
                // 如果不等，就更新前驱节点
                pre = pre.next;
                count++;
            }
            return head;
        }

        /**
         * 计算链表长度
         * @param root
         * @return
         */
        public int listNodeLen(ListNode root) {
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
        ListNode(int x) { val = x; }
    }
}
