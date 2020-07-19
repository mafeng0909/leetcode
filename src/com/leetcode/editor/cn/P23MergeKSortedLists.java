//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//
// 示例:
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6
// Related Topics 堆 链表 分治算法

package com.leetcode.editor.cn;
/**
 * Java：合并K个排序链表
 * 方法：分治算法
 *
 * @author mafeng
 */
public class P23MergeKSortedLists{
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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            if (lists.length == 1) {
                return lists[0];
            }
            if (lists.length == 2) {
                return mergeTwoLists(lists[0], lists[1]);
            }
            // 将数组分为两份
            int mid = lists.length / 2;
            ListNode[] subList1 = new ListNode[mid];
            ListNode[] subList2 = new ListNode[lists.length - mid];
            System.arraycopy(lists, 0, subList1, 0, mid);
            System.arraycopy(lists, mid, subList2, 0, lists.length - mid);

            // 递归
            ListNode l1 = mergeKLists(subList1);
            ListNode l2 = mergeKLists(subList2);

            return mergeTwoLists(l1, l2);
        }

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
