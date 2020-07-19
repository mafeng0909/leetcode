//实现一个基本的计算器来计算一个简单的字符串表达式的值。
//
// 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格 。
//
// 示例 1:
//
// 输入: "1 + 1"
//输出: 2
//
//
// 示例 2:
//
// 输入: " 2-1 + 2 "
//输出: 3
//
// 示例 3:
//
// 输入: "(1+(4+5+2)-3)+(6+8)"
//输出: 23
//
// 说明：
//
//
// 你可以假设所给定的表达式都是有效的。
// 请不要使用内置的库函数 eval。
//
// Related Topics 栈 数学

package com.leetcode.editor.cn;

import java.util.Stack;

/**
 * Java：基本计算器
 * 方法：用状态机编程思想
 *
 * @author mafeng
 */
public class P224BasicCalculator{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public int calculate(String s) {
            // 三种状态
            int startState = 0;
            int numberState = 1;
            int operationState = 2;
            // 操作数栈
            Stack<Integer> numStack = new Stack<>();
            // 操作符栈
            Stack<Character> operationStack = new Stack<>();
            // 初始状态
            int state = startState;
            // 计算标志位
            int computeFlag = 0;
            int number = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    continue;
                }
                switch (state) {
                    case 0 :
                        if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                            state = numberState;
                        }else {
                            state = operationState;
                        }
                        // 第一次循环需要将i重置，是第二次循环依然是从第一个字符开始
                        i--;
                        break;
                    case 1 :
                        if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                            number = number * 10 + s.charAt(i) - '0';
                        }else {
                            numStack.push(number);
                            if (computeFlag == 1) {
                                // 当标志位为1时，计算一次
                                compute(numStack, operationStack);
                            }
                            number = 0;
                            // 此循环中s.charAt(i)为操作符，所以需要退回一位
                            i--;
                            state = operationState;
                        }
                        break;
                    case 2 :
                        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                            operationStack.push(s.charAt(i));
                            // 当字符是加减操作符，将计算标志位置为1
                            computeFlag = 1;
                        }else if (s.charAt(i) == '(') {
                            state = numberState;
                            // 当字符是‘(’操作符，将计算标志位置为0
                            computeFlag = 0;
                        }else if (s.charAt(i) >= '0' && s.charAt(i) <='9') {
                            state = numberState;
                            i--;
                        }else if (s.charAt(i) == ')') {
                            // 计算一次
                            compute(numStack, operationStack);
                        }
                        break;
                    default:
                        break;
                }
            }
            // 最后是一个数字结尾的情况，所以还得将其压入栈，继续计算
            if (number != 0) {
                numStack.push(number);
                // 计算
                compute(numStack, operationStack);
            }
            if (number == 0 && numStack.isEmpty()) {
                return 0;
            }
            return numStack.peek();
        }

        /**
         * 计算
         * @param numStack
         * @param operationStack
         */
        public void compute(Stack<Integer> numStack, Stack<Character> operationStack) {
            if (numStack.size() <= 1) {
                return;
            }
            Integer top = numStack.pop();
            Character topOperation = operationStack.pop();
            if (topOperation == '+') {
                numStack.push(numStack.pop() + top);
            }else if (topOperation == '-') {
                numStack.push(numStack.pop() - top);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
