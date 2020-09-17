package com.test.editor.cn.shopee;

import java.util.Scanner;

/**
 * @author mafeng
 * @data 2020/9/16
 **/
public class Test091601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        String[] split = s.substring(1, s.length() - 1).split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        int len = arr.length;

        Node root = new Node(0);
        Node cur = root;
        for (int i : arr) {
            cur.next = new Node(i);
            cur = cur.next;
        }

        int num = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());

        // 添加第n个节点
        int index = 0;
        cur = root.next;
        if (n >= 0 && n < len) {
            len++;
            while (cur != null) {
                if (index == n) {
                    if (cur.next == null) {
                        cur.next = new Node(num);
                    }else {
                        Node next = cur.next;
                        Node node = new Node(num);
                        node.next = next;
                        cur.next = node;
                    }
                    break;
                }
                cur = cur.next;
                index++;
            }
        }

        // 删除第m个节点
        index = 0;
        cur = root.next;
        if (m == 0) {
            root.next = cur.next;
        }
        if (m > 0 && m < len) {
            while (cur != null) {
                if (index == m - 1) {
                    if (cur.next.next == null) {
                        cur.next = null;
                    }else {
                        cur.next = cur.next.next;
                    }
                    break;
                }
                cur = cur.next;
                index++;
            }
        }

        cur = root.next;
        while (cur != null) {
            System.out.print(cur.val);
            System.out.print(" ");
            cur = cur.next;
        }
    }

    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
