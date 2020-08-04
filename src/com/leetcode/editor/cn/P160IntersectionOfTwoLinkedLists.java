//编写一个程序，找到两个单链表相交的起始节点。 
//
// 如下面的两个链表： 
//
// 
//
// 在节点 c1 开始相交。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
// 
//
// 
//
// 注意： 
//
// 
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 
// Related Topics 链表

package com.leetcode.editor.cn;

/**
 * Java：相交链表
 * 方法一：使用set
 *        先讲第一个链表的所有节点都加入到set集合中，然后再遍历第二个链表，
 *        依次查找set集合中是否存在该节点，当找到的第一个就是相交的第一个节点
 * 方法二：先计算两个链表的长度，将长度长的链表头指针移动到和短链表一样的长度
 *        然后再同时遍历两个链表，第一个相等的就是相交的第一个节点
 * 方法三：定义两个指针，分别遍历两个链表，当遍历到最后一个节点的时候，
 *        将该节点指向另一个链表的头节点，然后继续遍历，相等则为交点
 *
 * @author mafeng
 */
public class P160IntersectionOfTwoLinkedLists{
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
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    static class Solution {
        /**
         * 方法二
         *
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lenA = getLength(headA);
            int lenB = getLength(headB);
            if (lenA > lenB) {
                headA = forwardHead(headA, lenA - lenB);
            }else {
                headB = forwardHead(headB, lenB - lenA);
            }
            while (headA != null && headB != null) {
                if (headA == headB) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return null;
        }

        /**
         * 计算链表的长度
         * @param head
         * @return
         */
        private int getLength(ListNode head) {
            int len = 0;
            while (head != null) {
                len++;
                head = head.next;
            }
            return len;
        }

        /**
         * 将长的链表往后移动
         * @param headA
         * @param n
         * @return
         */
        private ListNode forwardHead(ListNode headA, int n) {
            while (headA != null && n > 0) {
                headA = headA.next;
                n--;
            }
            return headA;
        }

        /**
         * 方法三
         * 此方法不适合判断无交点情况
         *
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode pA = headA;
            ListNode pB = headB;
            while (pA != pB) {
                pA = pA.next == null ? headB : pA.next;
                pB = pB.next == null ? headA : pB.next;
            }
            return pA;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    static class ListNode {
         int val;
         ListNode next;

         ListNode(int x) {
             val = x;
             next = null;
         }
    }
}