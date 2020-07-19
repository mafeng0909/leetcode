//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例：
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
//
// Related Topics 字符串 回溯算法

package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Java：括号生成
 * 分析：递归 + 回溯 + 剪枝
 *      临界条件：左右括号均不能超过n
 *      剪枝条件：右括号使用数量不能超过左括号使用的数量
 *
 * @author mafeng
 */
public class P22GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
//            dfs("", n, 0, 0, result);
            dfs2(new StringBuilder(), n, 0, 0, result);
            return result;
        }

        public static void dfs(String str, int n, int left, int right, List<String> result) {
            // 临界条件
            if (left == right && left == n) {
                result.add(str);
                return;
            }
            // 剪枝
            if (left < right) {
                return;
            }
            if (left < n) {
                dfs(str + "(", n, left + 1, right, result);
            }
            if (right < n) {
                dfs(str + ")", n, left, right + 1, result);
            }
        }

        public static void dfs2(StringBuilder sb, int n, int left, int right, List<String> result) {
            // 临界条件
            if (left == right && left == n) {
                result.add(sb.toString());
                return;
            }
            // 剪枝
            if (left < right) {
                return;
            }
            if (left < n) {
                dfs2(sb.append("("), n, left + 1, right, result);
                // 回溯
                sb.deleteCharAt(sb.length() - 1);
            }
            if (right < n) {
                dfs2(sb.append(")"), n, left, right + 1, result);
                // 回溯
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
