//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。 
//
// 注意: 
//
// num 的长度小于 10002 且 ≥ k。
// num 不会包含任何前导零。 
// 
// 示例 1 :
//
//输入: num = "1432219", k = 3
//输出: "1219"
//解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
// 
// 示例 2 :
//
//输入: num = "10200", k = 1
//输出: "200"
//解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
//
// 示例 3 : 
//
//输入: num = "10", k = 2
//输出: "0"
//解释: 从原数字移除所有的数字，剩余为空就是0。
// 
// Related Topics 栈 贪心算法

package com.leetcode.editor.cn;

import java.util.Stack;

/**
 * Java：移掉K位数字
 * 方法：用贪心算法和单调栈
 *
 * @author mafeng
 */
public class P402RemoveKDigits{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public String removeKdigits(String num, int k) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < num.length(); i++) {
                int number = Integer.parseInt(String.valueOf(num.charAt(i)));
//                int number = num.charAt(i) - '0';
                // 此处用while而不是if
                while (!stack.isEmpty() && k > 0 && stack.peek() > number) {
                    stack.pop();
                    k--;
                }
                if (number != 0 || !stack.isEmpty()) {
                    stack.push(number);
                }
            }
            // 当遍历完后仍存在 k>0
            while (k > 0 && !stack.isEmpty()) {
                stack.pop();
                k--;
            }
            // 将栈中的元素转化成字符串返回
            StringBuilder stringBuilder = new StringBuilder();
//            while (!stack.isEmpty()) {
//                stringBuilder.append(stack.pop());
//            }
            boolean flag = true;
            for (Integer integer : stack) {
                if (flag && integer == 0) {
                    continue;
                }
                flag = false;
                stringBuilder.append(integer);
            }
            if (stringBuilder.length() == 0) {
                return "0";
            }
            return stringBuilder.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}