//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
// Related Topics 链表

package com.leetcode.editor.cn;

/**
 * Java：反转链表 II
 *
 * @author mafeng
 */
public class P92ReverseLinkedListIi {
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
        public ListNode reverseBetween(ListNode head, int m, int n) {
            int len = n - m + 1;
            ListNode preHead = null;
            ListNode result = head;
            // 先找到pre_head
            while (head != null && m > 1) {
                preHead = head;
                head = head.next;
                m--;
            }
            // 反转之前是第m个node，反转之后是第n个node，记下，方便连接第三部分
            ListNode modifyListTail = head;
            // 将需要交换的部分进行反转
            ListNode newHead = null;
            // 使用头插法
            while (head != null && len > 0) {
                ListNode next = head.next;
                head.next = newHead;
                newHead = head;
                head = next;
                len--;
            }
            // 将交换部分的‘后置部分’链表和交换后的部分连接起来
            modifyListTail.next = head;
            // 将交换部分的‘前置部分’链表和交换后的部分连接起来
            if (preHead != null) {
                preHead.next = newHead;
            }else {
                result = newHead;
            }
            return result;
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
