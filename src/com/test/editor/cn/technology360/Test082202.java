package com.test.editor.cn.technology360;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/8/22
 **/
public class Test082202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] operate = new int[m];
        for (int i = 0; i < m; i++) {
            operate[i] = sc.nextInt();
        }

        TreeNode oddHead = new TreeNode(0);
        TreeNode evenHead = new TreeNode(0);
        TreeNode oddTail = oddHead;
        TreeNode evenTail = evenHead;

        // 将所有的数都按奇偶来拆分为两个链表
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                oddTail.next = new TreeNode(i);
                oddTail = oddTail.next;

            }else {
                evenTail.next = new TreeNode(i);
                evenTail = evenTail.next;
            }
        }
        // flag为false时，标志着oddNode为奇数
        // flag为true时，标志着evenNode为奇数
        boolean flag = false;
        for (int i : operate) {
            if (i == 1) {
                if (!flag) {
                    TreeNode node = oddHead.next;
                    oddHead.next = node.next;
                    oddTail.next = node;
                    oddTail = node;
                    flag = true;
                }else {
                    TreeNode node = evenHead.next;
                    evenHead.next = node.next;
                    evenTail.next = node;
                    evenTail = node;
                    flag = false;
                }
            }
            if (i == 2) {
                flag = !flag;
            }
        }

        // 进行输出
        if (!flag) {
            TreeNode first = oddHead.next;
            TreeNode second = evenHead.next;
            while (first != null && second != null) {
                System.out.print(first.val);
                System.out.print(" ");
                System.out.print(second.val);
                System.out.print(" ");

                first = first.next;
                second = second.next;
            }
        }else {
            TreeNode first = evenHead.next;
            TreeNode second = oddHead.next;
            while (first != null && second != null) {
                System.out.print(first.val);
                System.out.print(" ");
                System.out.print(second.val);
                System.out.print(" ");

                first = first.next;
                second = second.next;
            }
        }
    }

    static class TreeNode {
        int val;
        TreeNode next;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
