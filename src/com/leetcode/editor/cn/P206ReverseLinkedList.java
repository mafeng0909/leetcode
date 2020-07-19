//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表

package com.leetcode.editor.cn;
/**
 * Java：反转链表
 * @author mafeng
 */
public class P206ReverseLinkedList{
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
        public ListNode reverseList(ListNode head) {
            ListNode newHead = null;
            // 为了不改变原来的链表结构
            ListNode curHead = head;
            while (curHead != null) {
                ListNode next = curHead.next;
                curHead.next = newHead;
                newHead = curHead;
                curHead = next;
            }
            return newHead;
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