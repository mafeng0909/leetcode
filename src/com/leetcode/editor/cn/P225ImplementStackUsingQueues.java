//使用队列实现栈的下列操作： 
//
// 
// push(x) -- 元素 x 入栈 
// pop() -- 移除栈顶元素 
// top() -- 获取栈顶元素 
// empty() -- 返回栈是否为空 
// 
//
// 注意: 
//
// 
// 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合
//法的。 
// 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。 
// 
// Related Topics 栈 设计

package com.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Java：用队列实现栈
 * @author mafeng
 */
public class P225ImplementStackUsingQueues{
    public static void main(String[] args) {

        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class MyStack {

        private Queue<Integer> queue = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (queue.isEmpty()) {
                return 0;
            }
            if (queue.size() == 1) {
                return queue.poll();
            }

            Queue<Integer> tempQueue = new LinkedList<>();
            while (queue.size() > 1) {
                tempQueue.add(queue.poll());
            }
            int top = queue.poll();
            queue = tempQueue;
            return top;
        }

        /** Get the top element. */
        public int top() {
            if (queue.isEmpty()) {
                return 0;
            }
            if (queue.size() == 1) {
                return queue.peek();
            }

            Queue<Integer> tempQueue = new LinkedList<>();
            int top = 0;
            while (!queue.isEmpty()) {
                top = queue.poll();
                tempQueue.add(top);
            }
            queue = tempQueue;
            return top;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}