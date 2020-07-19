//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 堆 设计

package com.leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * Java：数据流的中位数
 * @author mafeng
 */
public class P295FindMedianFromDataStream{
    public static void main(String[] args) {
        // TO TEST
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class MedianFinder {

        private PriorityQueue<Integer> bigHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
        private PriorityQueue<Integer> smallHeap = new PriorityQueue<>();

        /** initialize your data structure here. */
        public MedianFinder() {

        }

        public void addNum(int num) {
            if (bigHeap.size() == 0 && smallHeap.size() == 0) {
                bigHeap.add(num);
                return;
            }
            // 大顶堆和小顶堆的长度相等
            if (bigHeap.size() == smallHeap.size()) {
                // num 大于 小顶堆的根节点的值
                if (num > smallHeap.peek()) {
                    smallHeap.add(num);
                }else {
                    bigHeap.add(num);
                }
            // 大顶堆 比 小顶堆 长
            }else if (bigHeap.size() > smallHeap.size()) {
                // num 小于 大顶堆的根节点的值
                if (num < bigHeap.peek()) {
                    bigHeap.add(num);
                    smallHeap.add(bigHeap.poll());
                }else {
                    smallHeap.add(num);
                }
            // 小顶堆 比 大顶堆 长
            }else {
                // num 大于 小顶堆的根节点的值
                if (num > smallHeap.peek()) {
                    smallHeap.add(num);
                    bigHeap.add(smallHeap.poll());
                }else {
                    bigHeap.add(num);
                }
            }
        }

        public double findMedian() {
            if (bigHeap.size() == smallHeap.size()) {
                return ((double) bigHeap.peek() + smallHeap.peek()) / 2;
            }else if (bigHeap.size() > smallHeap.size()) {
                return bigHeap.peek();
            }else {
                return smallHeap.peek();
            }
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}