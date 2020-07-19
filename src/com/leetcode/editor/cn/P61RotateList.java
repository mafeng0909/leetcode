//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
//
//
// 示例 2:
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL
// Related Topics 链表 双指针

package com.leetcode.editor.cn;
/**
 * Java：旋转链表
 */
public class P61RotateList{
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
        public ListNode rotateRight(ListNode head, int k) {
            // 求出链表的长度
            int len = getListNodeLen(head);
            if (len <= 1 || k == 0 || k % len == 0) {
                return head;
            }
            // index表示旋转后的尾结点索引
            int index =  len >= k ? len - k : len - (k % len);

            ListNode cur = new ListNode(0);
            cur.next = head;
            int count = 1;
            ListNode newHead = new ListNode(0);
            ListNode pre = new ListNode(0);
            while (count < len) {
                // 当遍历到旋转后的尾结点索引时，记录该节点，方便后面将其next置为null
                // 并且记录其后一个节点，该节点为旋转后的头节点
                if (count == index) {
                    pre.next = cur.next;
                    newHead.next = cur.next.next;
                }
                cur.next = cur.next.next;
                count++;
            }
            // 当遍历到在最后一个节点，将head连接到其后面
            cur.next.next = head;
            pre.next.next = null;
            return newHead.next;
        }

        public int getListNodeLen(ListNode root) {
            int count = 0;
            while (root != null) {
                count++;
                root = root.next;
            }
            return count;
        }

        /**
         * 优化
         * @param head
         * @param k
         * @return
         */
        public ListNode rotateRight2(ListNode head, int k) {
            if (head == null || head.next == null || k == 0) {
                return head;
            }
            // 计算链表长度
            int len = 1;
            ListNode cur = head;
            while (cur.next != null) {
                len++;
                cur = cur.next;
            }
            // 将链表的最后一个节点与头节点进行连接
            cur.next = head;
            // 计算头节点索引
            k = len - (k % len);
            while (k > 0) {
                cur = cur.next;
                k--;
            }
            head = cur.next;
            cur.next = null;
            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
