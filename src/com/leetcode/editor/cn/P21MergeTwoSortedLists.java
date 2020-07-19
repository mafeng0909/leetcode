//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package com.leetcode.editor.cn;
/**
 * Java：合并两个有序链表
 * @author mafeng
 */
public class P21MergeTwoSortedLists{
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode mergeHead = new ListNode(0);
            ListNode mergePtr = mergeHead;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    mergePtr.next = l1;
                    l1 = l1.next;
                }else {
                    mergePtr.next = l2;
                    l2 = l2.next;
                }
                mergePtr = mergePtr.next;
            }
            if (l1 != null) {
                mergePtr.next = l1;
            }
            if (l2 != null) {
                mergePtr.next = l2;
            }
            return mergeHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}