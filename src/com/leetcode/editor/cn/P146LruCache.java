//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 
// 👍 771 👎 0


package com.leetcode.editor.cn;

import java.util.HashMap;

/**
 * Java：LRU缓存机制
 * 
 * @author: mafeng
 * @data: 2020-07-27 09:32:50
 **/
public class P146LruCache{
    public static void main(String[] args) {
        // TO TEST
        LruCache lruCache = new LruCache(5);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        lruCache.put(5, 5);
        lruCache.get(1);
        lruCache.put(1, 6);
        lruCache.put(6, 6);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(6));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class LruCache {

        private int currentSize;
        private int capacity;
        private HashMap<Object, Node> caches;
        private Node firstNode;
        private Node lastNode;

        public LruCache(int capacity) {
            this.currentSize = 0;
            this.capacity = capacity;
            this.caches = new HashMap<>(this.capacity);
        }

        /**
         * 获取元素
         *
         * @param key
         * @return
         */
        public int get(int key) {
            Node node = caches.get(key);
            if (node == null) {
                return -1;
            }
            // 如果存在，则需要将其移动到双向链表的头节点位置
            moveToHead(node);
            return (int)node.value;
        }

        /**
         * 加入元素
         *
         * @param key
         * @param value
         */
        public void put(int key, int value) {
            // 先判断是否有该节点
            Node node = caches.get(key);
            if (node == null) {
                // 判断是否超出容量, 超出则进行删除链表最后一个元素
                if (currentSize == capacity) {
                    remove((int)lastNode.key);
                    currentSize--;
                }
                // 创建一个新节点
                Node newNode = new Node(key, value);
                moveToHead(newNode);
                caches.put(key, newNode);
                // 当前容量+1
                currentSize++;
            }else {
                node.value = value;
                // 调整元素的位置
                moveToHead(node);
                caches.replace(key, node);
            }
        }

        /**
         * 更新访问到的node在双向链表中的位置 -> 内部方法
         * 包括：1. 新加进来元素的位置调整
         *      2. 已存在的元素的位置调整
         *
         * @param node
         */
        private void moveToHead(Node node) {
            // 1.1 首次添加元素到链表中
            if (firstNode == null || lastNode == null) {
                firstNode = lastNode = node;
                return;
            }
            // 2.1 先判断首节点是否是该节点
            if (firstNode == node) {
                return;
            }
            // 2.2 将node的前后节点进行调整
            if (lastNode == node) {
                lastNode = lastNode.prev;
                lastNode.next = null;
            }else {
                if (node.prev != null) {
                    node.prev.next = node.next;
                }
                if (node.next != null) {
                    node.next.prev = node.prev;
                }
            }

            // 将node节点调整到头节点, 注：新加入的元素直接执行这里
            node.next = firstNode;
            firstNode.prev = node;
            node.prev = null;
            firstNode = node;
        }

        /**
         * 删除链表元素
         * 包含：1. 删除最近最不常使用，即最后一个元素
         *      2. 删除指定的节点
         *
         * @param key
         */
        private void remove(int key) {
            Node node = caches.get(key);
            if (node != null) {
                // 1. 删除最近最不常使用，即最后一个元素
                if (lastNode == node) {
                    lastNode = lastNode.prev;
                // 2. 删除指定的节点
                }else {
                    if (firstNode == node) {
                        firstNode = firstNode.next;
                        firstNode.prev = null;
                    }else {
                        if (node.prev != null) {
                            node.prev.next = node.next;
                        }
                        if (node.next != null) {
                            node.next.prev = node.prev;
                        }
                    }
                }
            }
            caches.remove(key);
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    //leetcode submit region end(Prohibit modification and deletion)

    static class Node {
        private Object key;
        private Object value;
        private Node prev;
        private Node next;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}