//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针

package com.leetcode.editor.cn;
/**
 * Java：分隔链表
 * 方法：巧用临时头节点和指针
 *
 * @author mafeng
 */
public class P86PartitionList{
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
        public ListNode partition(ListNode head, int x) {
            ListNode lessHead = new ListNode(0);
            ListNode moreHead = new ListNode(0);
            ListNode lessPtr = lessHead;
            ListNode morePtr = moreHead;
            while (head != null) {
                if (head.val < x) {
                    lessPtr.next = head;
                    lessPtr = lessPtr.next;
                }else {
                    morePtr.next = head;
                    morePtr = morePtr.next;
                }
                head = head.next;
            }
            // 将链表最后置为null
            morePtr.next = null;
            lessPtr.next = moreHead.next;
            return lessHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }
}